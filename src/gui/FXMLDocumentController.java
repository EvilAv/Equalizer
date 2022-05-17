package gui;


import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import player.AudioPlayer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class FXMLDocumentController implements Initializable {

    // слайдеры для фильтров и уровня громкости
    @FXML
    private Slider Slider0, soundSlider;
    // графики частот
    @FXML
    private LineChart chart1;
    @FXML
    private LineChart chart2;
    @FXML
    private NumberAxis xAxis1, yAxis1, xAxis2, yAxis2;
    private AudioPlayer audioPlayer;
    private Thread playThread, plotThread;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //инициализируем чекбоксы и слайдеры
        this.listenSliders();
        this.initialGraph();
        this.volumeFromSlider();
    }

    @FXML
    private void open() throws FileNotFoundException, IOException, LineUnavailableException, UnsupportedAudioFileException, InterruptedException {
        //Выбор файлов формата wav
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Audio Files", "*.wav"));
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if(selectedFile == null) return;

        this.audioPlayer = new AudioPlayer(selectedFile);
        playThread = new Thread(()->{
            this.audioPlayer.play();
        });
        playThread.start();

        System.out.println("PLAY");
    }

    // обработчик нажатия на кнопку play (продолжить проигрывать музыку)
    @FXML
    private void play() {
        if (this.audioPlayer != null)
            this.audioPlayer.setPause(false);
    }

    // обработчик нажатия на кнопку pause (приостановка программы)
    @FXML
    private void pause() {
        if (this.audioPlayer != null)
            this.audioPlayer.setPause(true);
    }

    // обработчик нажатия на кнопку stop (возврат к исходным параметрам)
    @FXML
    private void stop() {
        if (this.audioPlayer == null) return;
        Slider0.setValue(0);
        soundSlider.setValue(0.65);
    }


    // обработчик нажатия на кнопку X (заверщение работы программы)
    @FXML
    private void clickClose() {
        if(this.audioPlayer != null) {
            if(this.playThread != null)
                this.playThread.interrupt();
            this.audioPlayer.getEqualizer().close();
            this.audioPlayer.close();
        }

        System.exit(0);
    }

    //Метод, осуществляющий прослушку слайдеров и изменяющий КУ полос эквалайзера
    private void listenSliders(){
        Slider0.valueProperty().addListener((observable, oldValue, newValue) -> {
            audioPlayer.getEqualizer().getFilter((short)0).setGain((float)newValue.doubleValue());
        });

    }


    private XYChart.Data[] oldData;
    private XYChart.Data[] newData;
    //Метод, осуществляющий инициализацию графиков
    private void initialGraph(){
        XYChart.Series oldGraph = new XYChart.Series<>();
        XYChart.Series newGraph = new XYChart.Series<>();
        int size = 512;
        oldData = new XYChart.Data[size];
        newData = new XYChart.Data[size];
        for (int i = 0; i < oldData.length; i++){
            oldData[i] = new XYChart.Data<>(i, 0);
            oldGraph.getData().add(oldData[i]);

            newData[i] = new XYChart.Data<>(i, 0);
            newGraph.getData().add(newData[i]);
        }

        chart1.getData().add(oldGraph);
        chart2.getData().add(newGraph);
        chart1.setCreateSymbols(false);
        chart2.setCreateSymbols(false);
        chart1.setAnimated(false);
        chart2.setAnimated(false);

        this.chart1.getYAxis();
        this.yAxis1.setLowerBound(-0.2);
        this.yAxis1.setUpperBound(0.3);
        this.yAxis1.setAnimated(false);

        this.chart2.getYAxis();
        this.yAxis2.setLowerBound(-0.2);
        this.yAxis2.setUpperBound(0.3);
        this.yAxis2.setAnimated(false);
    }


    // управление громкостью при помощи слайдера
    private void volumeFromSlider() {
        soundSlider.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            audioPlayer.setVolume(newValue.doubleValue());
        });
    }

    // отрисовка графиков при нажатии чекбокса при помощи потоков
    private boolean graphFlag = false;
    @FXML
    private void clickPlot(){
        if (this.graphFlag == false){
            this.graphFlag = true;
        }
        else this.graphFlag = false;
        //System.out.println("PLOT");
        this.plotThread = new Thread(()->{
            while(this.graphFlag){
                if(this.graphFlag == false)
                    for(;;){
                        try{
                            if(this.graphFlag == true) break;
                            this.plotThread.sleep(50);
                        }
                        catch(Exception e){
                        }
                    }

                if(audioPlayer.isCalculated){
                    for(int j = 0; j < this.audioPlayer.getFourierInput().length; j++){
                        //System.out.println("plotddd");
                        this.oldData[j].setYValue(Math.log10(this.audioPlayer.getFourierInput()[j] * 0.1) / 10);
                        this.newData[j].setYValue(Math.log10(this.audioPlayer.getFourierOutput()[j] * 0.1) / 10);
                    }
                }
                try {
                    this.plotThread.sleep(60);
                }
                catch (Exception e) {
                }
            }
        });
        plotThread.start();
    }
}
