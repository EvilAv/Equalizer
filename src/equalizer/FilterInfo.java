package equalizer;

public final class FilterInfo {
    // задаем порядок КИХ фильтра
    public final static short COUNT_OF_COEFS = 120;

    // коэффициенты для ФНЧ
    public static final double[] COEFS_OF_BAND_0 =  {
            8.283170749895558E-6, 1.0256928586241847E-5, 1.6490886128341317E-5, 2.509625368975527E-5,
            3.666906252919753E-5, 5.18978658178397E-5, 7.156893754543887E-5, 9.657035591650236E-5,
            1.2789473301296156E-4, 1.6664035573301728E-4, 2.1401051225918325E-4, 2.713107938687614E-4,
            3.3994418394186246E-4, 4.2140377455402453E-4, 5.172629859032043E-4, 6.291632046803353E-4,
            7.587988038370593E-4, 9.078995573463118E-4, 0.001078210518635119, 0.001271469489381461,
            0.0014893822651555987, 0.0017335959046798422, 0.0020056703289159828, 0.002307048613340458,
            0.002639026390178275, 0.003002720825587854, 0.003399039678413349, 0.0038286509808218776,
            0.004291953905711376, 0.00478905140015481, 0.005319725167469139, 0.005883413572110663,
            0.006479193021092099, 0.00710576334284371, 0.007761437639530849, 0.00844413703220786,
            0.009151390650534507, 0.009880341141085316, 0.010627755881791177, 0.011390043996256757,
            0.01216327916230638, 0.0129432281060164, 0.013725384567732157, 0.01450500842227818,
            0.01527716953394232, 0.016036795830039134, 0.01677872498707867, 0.01749775904282534,
            0.018188721177720385, 0.018846513851952067, 0.019466177441344285, 0.020042948487366454,
            0.02057231666480679, 0.021050079575519826, 0.021472394498325827, 0.021835826263411233,
            0.022137390473898292, 0.022374591366707372, 0.022545453688178764, 0.02264854805559538,
            0.02268300938191347, 0.02264854805559538, 0.022545453688178764, 0.022374591366707372,
            0.022137390473898292, 0.021835826263411233, 0.021472394498325827, 0.021050079575519826,
            0.02057231666480679, 0.020042948487366454, 0.019466177441344285, 0.018846513851952067,
            0.018188721177720385, 0.01749775904282534, 0.01677872498707867, 0.016036795830039134,
            0.01527716953394232, 0.01450500842227818, 0.013725384567732157, 0.0129432281060164,
            0.01216327916230638, 0.011390043996256757, 0.010627755881791177, 0.009880341141085316,
            0.009151390650534507, 0.00844413703220786, 0.007761437639530849, 0.00710576334284371,
            0.006479193021092099, 0.005883413572110663, 0.005319725167469139, 0.00478905140015481,
            0.004291953905711376, 0.0038286509808218776, 0.003399039678413349, 0.003002720825587854,
            0.002639026390178275, 0.002307048613340458, 0.0020056703289159828, 0.0017335959046798422,
            0.0014893822651555987, 0.001271469489381461, 0.001078210518635119, 9.078995573463118E-4,
            7.587988038370593E-4, 6.291632046803353E-4, 5.172629859032043E-4, 4.2140377455402453E-4,
            3.3994418394186246E-4, 2.713107938687614E-4, 2.1401051225918325E-4, 1.6664035573301728E-4,
            1.2789473301296156E-4, 9.657035591650236E-5, 7.156893754543887E-5, 5.18978658178397E-5,
            3.666906252919753E-5, 2.509625368975527E-5, 1.6490886128341317E-5, 1.0256928586241847E-5,
            8.283170749895558E-6
    };

    // коэффициенты для ПФ
    public static final double[] COEFS_OF_BAND_1 = {
            4.184779842935761E-7, 8.418918391189626E-7, 1.8714814902583908E-6, 3.6319546287584103E-6,
            6.445283931709457E-6, 1.0722776373986416E-5, 1.6978768746997977E-5, 2.5844452209440445E-5,
            3.808144247769035E-5, 5.459466136087018E-5, 7.644405159343879E-5, 1.0485461257311194E-4,
            1.4122422183827945E-4, 1.871286979051342E-4, 2.443235661589163E-4, 3.14742012243425E-4,
            4.004885477892667E-4, 5.038279718523592E-4, 6.271692880506788E-4, 7.730443314624573E-4,
            9.440809696558232E-4, 0.0011429708669264997, 0.001372431937506071, 0.0016351657591959234,
            0.0019338103701140267, 0.002270889024128383, 0.0026487556308858744, 0.003069537749711638,
            0.00353507813855034, 0.0040468759750942745, 0.004606028963031271, 0.005213177608015661,
            0.005868452992054403, 0.006571429388642823, 0.0073210830420297945, 0.008115758381105072,
            0.008953142851140121, 0.009830251425482144, 0.010743421705778562, 0.011688320335845031,
            0.012659961244273233, 0.013652735998568533, 0.014660456304061681, 0.01567640841976569,
            0.016693418996985326, 0.017703931581427, 0.01870009276257718, 0.019673846711982634,
            0.020617036631341654, 0.021521511438165972, 0.02237923585678973, 0.023182401960513722,
            0.023923540130611667, 0.02459562736268192, 0.02519219086215916, 0.0257074049292619,
            0.026136179238556316, 0.02647423676774605, 0.026718179821133402, 0.026865542821202064,
            0.026914830801687217, 0.026865542821202064, 0.026718179821133402, 0.02647423676774605,
            0.026136179238556316, 0.0257074049292619, 0.02519219086215916, 0.02459562736268192,
            0.023923540130611667, 0.023182401960513722, 0.02237923585678973, 0.021521511438165972,
            0.020617036631341654, 0.019673846711982634, 0.01870009276257718, 0.017703931581427,
            0.016693418996985326, 0.01567640841976569, 0.014660456304061681, 0.013652735998568533,
            0.012659961244273233, 0.011688320335845031, 0.010743421705778562, 0.009830251425482144,
            0.008953142851140121, 0.008115758381105072, 0.0073210830420297945, 0.006571429388642823,
            0.005868452992054403, 0.005213177608015661, 0.004606028963031271, 0.0040468759750942745,
            0.00353507813855034, 0.003069537749711638, 0.0026487556308858744, 0.002270889024128383,
            0.0019338103701140267, 0.0016351657591959234, 0.001372431937506071, 0.0011429708669264997,
            9.440809696558232E-4, 7.730443314624573E-4, 6.271692880506788E-4, 5.038279718523592E-4,
            4.004885477892667E-4, 3.14742012243425E-4, 2.443235661589163E-4, 1.871286979051342E-4,
            1.4122422183827945E-4, 1.0485461257311194E-4, 7.644405159343879E-5, 5.459466136087018E-5,
            3.808144247769035E-5, 2.5844452209440445E-5, 1.6978768746997977E-5, 1.0722776373986416E-5,
            6.445283931709457E-6, 3.6319546287584103E-6, 1.8714814902583908E-6, 8.418918391189626E-7,
            4.184779842935761E-7
    };

    // коэффициенты для ПФ
    public static final double[] COEFS_OF_BAND_2 = {
            -1.0134983360802145E-5, -1.310894626272609E-5, -2.1905494518574115E-5, -3.448497905351353E-5,
            -5.1889781517102813E-5, -7.53038801711441E-5, -1.0603809729722436E-4, -1.4550503812582697E-4,
            -1.9518250657649748E-4, -2.565644889947286E-4, -3.3109920033243403E-4, -4.2011418298213874E-4,
            -5.247290265497801E-4, -6.457569215832113E-4, -7.835969506805706E-4, -9.381197306000616E-4,
            -0.0011085497189179823, -0.001293348155207839, -0.0014901011845240577, -0.001695418174662765,
            -0.001904845554004963, -0.0021128016325201865, -0.002312537798319256, -0.0024961311860904906,
            -0.0026545133799657297, -0.0027775389392830606, -0.0028540965290398115, -0.002872264216047007,
            -0.002819509086247235, -0.0026829297881079688, -0.0024495389606943763, -0.002106580820225143,
            -0.001641877518988693, -0.001044196322584371, -3.03628243811557E-4, 5.880324093322492E-4,
            0.001636919006373757, 0.002846746072207698, 0.00421849741756951, 0.0057501608153836875,
            0.007436520428557037, 0.009269017073951766, 0.011235684870664626, 0.013321170902969026,
            0.01550684228055711, 0.017770982467477266, 0.020089076055959224, 0.022434178372116732,
            0.024777363514410646, 0.027088241743280124, 0.029335534661539635, 0.03148769444547394,
            0.03351355159300075, 0.03538297432253787, 0.03706752194351303, 0.03854107426776442,
            0.03978041946113909, 0.04076578364571528, 0.04148128703281289, 0.041915313351700595,
            0.04206078177532156, 0.041915313351700595, 0.04148128703281289, 0.04076578364571528,
            0.03978041946113909, 0.03854107426776442, 0.03706752194351303, 0.03538297432253787,
            0.03351355159300075, 0.03148769444547394, 0.029335534661539635, 0.027088241743280124,
            0.024777363514410646, 0.022434178372116732, 0.020089076055959224, 0.017770982467477266,
            0.01550684228055711, 0.013321170902969026, 0.011235684870664626, 0.009269017073951766,
            0.007436520428557037, 0.0057501608153836875, 0.00421849741756951, 0.002846746072207698,
            0.001636919006373757, 5.880324093322492E-4, -3.03628243811557E-4, -0.001044196322584371,
            -0.001641877518988693, -0.002106580820225143, -0.0024495389606943763, -0.0026829297881079688,
            -0.002819509086247235, -0.002872264216047007, -0.0028540965290398115, -0.0027775389392830606,
            -0.0026545133799657297, -0.0024961311860904906, -0.002312537798319256, -0.0021128016325201865,
            -0.001904845554004963, -0.001695418174662765, -0.0014901011845240577, -0.001293348155207839,
            -0.0011085497189179823, -9.381197306000616E-4, -7.835969506805706E-4, -6.457569215832113E-4,
            -5.247290265497801E-4, -4.2011418298213874E-4, -3.3109920033243403E-4, -2.565644889947286E-4,
            -1.9518250657649748E-4, -1.4550503812582697E-4, -1.0603809729722436E-4, -7.53038801711441E-5,
            -5.1889781517102813E-5, -3.448497905351353E-5, -2.1905494518574115E-5, -1.310894626272609E-5,
            -1.0134983360802145E-5
    };

    // коэффициенты для ПФ
    public static final double[] COEFS_OF_BAND_3 = {
            -3.262290503486085E-7, -2.1525267424217115E-7, 1.559295531031155E-7, 1.297197866391192E-6,
            3.850415801108198E-6, 8.73133095695894E-6, 1.71625774952833E-5, 3.068120647738231E-5,
            5.110860048568483E-5, 8.047056905685754E-5, 1.2085671657990095E-4, 1.7421105435832152E-4,
            2.4205040715411172E-4, 3.2511340170789853E-4, 4.229504985736835E-4, 5.334742210179299E-4,
            6.524978348560447E-4, 7.732994612010079E-4, 8.862560567570784E-4, 9.785969117079368E-4,
            0.0010343283552489736, 0.0010343794019127385, 9.570115098494695E-4, 7.785241515234055E-4,
            4.742715951596571E-4, 1.9985672067850894E-5, -6.066246761624738E-4, -0.0014240522183222844,
            -0.002445029900797111, -0.0036745345161122746, -0.005107881369774452, -0.0067290498032235345,
            -0.008509385377520105, -0.010406820822737079, -0.012365743551503772, -0.014317612375033593,
            -0.016182390609470063, -0.017870818431093748, -0.01928749636284384, -0.02033469710643137,
            -0.020916768086452386, -0.020944935891537238, -0.020342280194075024, -0.019048612386642176,
            -0.017024976245368344, -0.01425748676999107, -0.010760240273724018, -0.00657706391865277,
            -0.0017819250463455615, 0.003522112599811082, 0.009205420922665875, 0.015115778768754745,
            0.02108364804920064, 0.026928539167820908, 0.032466178929597515, 0.037516137568481406,
            0.04190953392954799, 0.04549642215505937, 0.048152471035593475, 0.04978457852005986,
            0.050335117169138965, 0.04978457852005986, 0.048152471035593475, 0.04549642215505937,
            0.04190953392954799, 0.037516137568481406, 0.032466178929597515, 0.026928539167820908,
            0.02108364804920064, 0.015115778768754745, 0.009205420922665875, 0.003522112599811082,
            -0.0017819250463455615, -0.00657706391865277, -0.010760240273724018, -0.01425748676999107,
            -0.017024976245368344, -0.019048612386642176, -0.020342280194075024, -0.020944935891537238,
            -0.020916768086452386, -0.02033469710643137, -0.01928749636284384, -0.017870818431093748,
            -0.016182390609470063, -0.014317612375033593, -0.012365743551503772, -0.010406820822737079,
            -0.008509385377520105, -0.0067290498032235345, -0.005107881369774452, -0.0036745345161122746,
            -0.002445029900797111, -0.0014240522183222844, -6.066246761624738E-4, 1.9985672067850894E-5,
            4.742715951596571E-4, 7.785241515234055E-4, 9.570115098494695E-4, 0.0010343794019127385,
            0.0010343283552489736, 9.785969117079368E-4, 8.862560567570784E-4, 7.732994612010079E-4,
            6.524978348560447E-4, 5.334742210179299E-4, 4.229504985736835E-4, 3.2511340170789853E-4,
            2.4205040715411172E-4, 1.7421105435832152E-4, 1.2085671657990095E-4, 8.047056905685754E-5,
            5.110860048568483E-5, 3.068120647738231E-5, 1.71625774952833E-5, 8.73133095695894E-6,
            3.850415801108198E-6, 1.297197866391192E-6, 1.559295531031155E-7, -2.1525267424217115E-7,
            -3.262290503486085E-7
    };

    // коэффициенты для ПФ
    public static final double[] COEFS_OF_BAND_4 = {
            6.680798434004374E-7, 1.7229154624043062E-6, 4.36736913483519E-6, 8.948430433763566E-6,
            1.568611643235738E-5, 2.4110081105917827E-5, 3.2679735293415954E-5, 3.85175930272478E-5,
            3.740446980297762E-5, 2.4174506034575214E-5, -6.4103148968524405E-6, -5.833358642910357E-5,
            -1.3271595925504315E-4, -2.2624456605869472E-4, -3.300765334088167E-4, -4.2969060990975E-4,
            -5.060826155555251E-4, -5.384878065086185E-4, -5.084790083507912E-4, -4.048826215726472E-4,
            -2.2855849342375126E-4, 4.190733726322454E-6, 2.608738276548946E-4, 4.95778395650529E-4,
            6.571282866547361E-4, 6.980507926847759E-4, 5.899585763714118E-4, 3.359743552235589E-4,
            -1.8676277255609552E-5, -3.825762654225346E-4, -6.231273782167255E-4, -5.82242330643094E-4,
            -1.0244687336238426E-4, 9.391271444603661E-4, 0.0025936280197417037, 0.00480680729172527,
            0.007396197236001463, 0.010046133420982038, 0.012325736365056444, 0.013731740575128631,
            0.01375387058154658, 0.01195595032547513, 0.008061894982492521, 0.0020330009040914017,
            -0.005877783068299249, -0.01510723659411273, -0.024807418469034222, -0.03391778315511706,
            -0.04127897683076946, -0.0457761259157707, -0.04649337360133339, -0.04285776390636282,
            -0.034750153447348456, -0.022563984395462304, -0.007199218293712142, 0.010012338706562039,
            0.027444014474804136, 0.04335761821578375, 0.05610962138036781, 0.0643523777479072,
            0.06720246553591906, 0.0643523777479072, 0.05610962138036781, 0.04335761821578375,
            0.027444014474804136, 0.010012338706562039, -0.007199218293712142, -0.022563984395462304,
            -0.034750153447348456, -0.04285776390636282, -0.04649337360133339, -0.0457761259157707,
            -0.04127897683076946, -0.03391778315511706, -0.024807418469034222, -0.01510723659411273,
            -0.005877783068299249, 0.0020330009040914017, 0.008061894982492521, 0.01195595032547513,
            0.01375387058154658, 0.013731740575128631, 0.012325736365056444, 0.010046133420982038,
            0.007396197236001463, 0.00480680729172527, 0.0025936280197417037, 9.391271444603661E-4,
            -1.0244687336238426E-4, -5.82242330643094E-4, -6.231273782167255E-4, -3.825762654225346E-4,
            -1.8676277255609552E-5, 3.359743552235589E-4, 5.899585763714118E-4, 6.980507926847759E-4,
            6.571282866547361E-4, 4.95778395650529E-4, 2.608738276548946E-4, 4.190733726322454E-6,
            -2.2855849342375126E-4, -4.048826215726472E-4, -5.084790083507912E-4, -5.384878065086185E-4,
            -5.060826155555251E-4, -4.2969060990975E-4, -3.300765334088167E-4, -2.2624456605869472E-4,
            -1.3271595925504315E-4, -5.833358642910357E-5, -6.4103148968524405E-6, 2.4174506034575214E-5,
            3.740446980297762E-5, 3.85175930272478E-5, 3.2679735293415954E-5, 2.4110081105917827E-5,
            1.568611643235738E-5, 8.948430433763566E-6, 4.36736913483519E-6, 1.7229154624043062E-6,
            6.680798434004374E-7
    };

    // коэффициенты для ПФ
    public static final double[] COEFS_OF_BAND_5 = { // 7
            3.160117588924433E-6, 3.8733534972636655E-6, 3.361700164988976E-6, -2.1830834384272262E-6,
            -1.3764353216907135E-5, -2.7786348927839016E-5, -3.585111571987776E-5, -2.902584137352253E-5,
            -5.317439409504091E-6, 2.4886696208758137E-5, 4.188530825454282E-5, 3.0420646779678873E-5,
            -2.5231696871818657E-6, -2.0158700624533283E-5, 2.833776033470922E-5, 1.6913885312266796E-4,
            3.627185396581958E-4, 4.93716128506388E-4, 4.1606199368692735E-4, 4.479152830355564E-5,
            -5.54589661379993E-4, -0.001147266135234312, -0.0014226146371370235, -0.0011734669330172687,
            -4.610779920225777E-4, 3.5856568144053413E-4, 8.111193604393935E-4, 6.186528455259026E-4,
            -3.446433994996288E-5, -4.967657760249257E-4, 4.28874041649033E-6, 0.0018018583326973284,
            0.004348870944252807, 0.006249971907112688, 0.005895121561584385, 0.002445309719986522,
            -0.0033900326416100857, -0.009355480721089294, -0.012630688327192273, -0.011390037111592933,
            -0.006065012837703748, 5.723196925842157E-4, 0.004811390187655852, 0.004292431597718162,
            -1.2805316006153495E-4, -0.0042616237477109365, -0.0027088822689828387, 0.007627265759189429,
            0.024558683935175938, 0.040181961319215725, 0.04389777670964566, 0.027886847766751436,
            -0.00760147239404317, -0.05218994906808367, -0.0883069013601459, -0.09841418694797323,
            -0.07342017171886674, -0.018148560366294066, 0.04919560015755179, 0.10385388263594403,
            0.12480799368357275, 0.10385388263594403, 0.04919560015755179, -0.018148560366294066,
            -0.07342017171886674, -0.09841418694797323, -0.0883069013601459, -0.05218994906808367,
            -0.00760147239404317, 0.027886847766751436, 0.04389777670964566, 0.040181961319215725,
            0.024558683935175938, 0.007627265759189429, -0.0027088822689828387, -0.0042616237477109365,
            -1.2805316006153495E-4, 0.004292431597718162, 0.004811390187655852, 5.723196925842157E-4,
            -0.006065012837703748, -0.011390037111592933, -0.012630688327192273, -0.009355480721089294,
            -0.0033900326416100857, 0.002445309719986522, 0.005895121561584385, 0.006249971907112688,
            0.004348870944252807, 0.0018018583326973284, 4.28874041649033E-6, -4.967657760249257E-4,
            -3.446433994996288E-5, 6.186528455259026E-4, 8.111193604393935E-4, 3.5856568144053413E-4,
            -4.610779920225777E-4, -0.0011734669330172687, -0.0014226146371370235, -0.001147266135234312,
            -5.54589661379993E-4, 4.479152830355564E-5, 4.1606199368692735E-4, 4.93716128506388E-4,
            3.627185396581958E-4, 1.6913885312266796E-4, 2.833776033470922E-5, -2.0158700624533283E-5,
            -2.5231696871818657E-6, 3.0420646779678873E-5, 4.188530825454282E-5, 2.4886696208758137E-5,
            -5.317439409504091E-6, -2.902584137352253E-5, -3.585111571987776E-5, -2.7786348927839016E-5,
            -1.3764353216907135E-5, -2.1830834384272262E-6, 3.361700164988976E-6, 3.8733534972636655E-6,
            3.160117588924433E-6
    };

    // коэффициенты для ПФ
    public static final double[] COEFS_OF_BAND_6 = { // 5
            -3.279059758719866E-6, -4.5359959062623105E-6, 1.8723840944118428E-7, 4.5087108945731114E-6,
            -4.898039592785706E-7, 4.51913833223786E-6, 3.0013871408559523E-5, 2.209242440491495E-5,
            -5.059637229287926E-5, -8.665393509725763E-5, -7.3429795455398874E-6, 5.2919284199970983E-5,
            -4.880048160974583E-6, 2.9450017187454087E-5, 2.442144174212825E-4, 2.036528536253877E-4,
            -3.000236892875962E-4, -5.638472500477719E-4, -1.0189566112321143E-4, 2.7340355353469597E-4,
            -2.2609809686675176E-5, 8.257345644882147E-5, 0.0010902725815773702, 0.0010447509093407705,
            -0.0010429882141077596, -0.002287183833119716, -6.107691910974016E-4, 9.301631453054466E-4,
            -6.79985718905704E-5, 7.783913148921087E-5, 0.003452776884030558, 0.003795464620413156,
            -0.0025597944936925302, -0.006946417896392569, -0.002430371217356673, 0.002418700593681415,
            -1.4963499086067565E-4, -3.352136316480137E-4, 0.008777629262805352, 0.01108403460158373,
            -0.004804221273891665, -0.01765528310635503, -0.007677840729758505, 0.005330028824123171,
            -2.5527898781767055E-4, -0.002136086711200335, 0.020084284419513557, 0.02954007287720092,
            -0.007182915252014057, -0.04323061226580057, -0.023153451455157084, 0.011746516314806008,
            -3.48156608486708E-4, -0.009477415082587285, 0.05453897645284214, 0.10152642216487713,
            -0.00874154845414108, -0.181548608499604, -0.15351084053515318, 0.0961042251957796,
            0.2496142492631927, 0.0961042251957796, -0.15351084053515318, -0.181548608499604,
            -0.00874154845414108, 0.10152642216487713, 0.05453897645284214, -0.009477415082587285,
            -3.48156608486708E-4, 0.011746516314806008, -0.023153451455157084, -0.04323061226580057,
            -0.007182915252014057, 0.02954007287720092, 0.020084284419513557, -0.002136086711200335,
            -2.5527898781767055E-4, 0.005330028824123171, -0.007677840729758505, -0.01765528310635503,
            -0.004804221273891665, 0.01108403460158373, 0.008777629262805352, -3.352136316480137E-4,
            -1.4963499086067565E-4, 0.002418700593681415, -0.002430371217356673, -0.006946417896392569,
            -0.0025597944936925302, 0.003795464620413156, 0.003452776884030558, 7.783913148921087E-5,
            -6.79985718905704E-5, 9.301631453054466E-4, -6.107691910974016E-4, -0.002287183833119716,
            -0.0010429882141077596, 0.0010447509093407705, 0.0010902725815773702, 8.257345644882147E-5,
            -2.2609809686675176E-5, 2.7340355353469597E-4, -1.0189566112321143E-4, -5.638472500477719E-4,
            -3.000236892875962E-4, 2.036528536253877E-4, 2.442144174212825E-4, 2.9450017187454087E-5,
            -4.880048160974583E-6, 5.2919284199970983E-5, -7.3429795455398874E-6, -8.665393509725763E-5,
            -5.059637229287926E-5, 2.209242440491495E-5, 3.0013871408559523E-5, 4.51913833223786E-6,
            -4.898039592785706E-7, 4.5087108945731114E-6, 1.8723840944118428E-7, -4.5359959062623105E-6,
            -3.279059758719866E-6
    };

    // коэффициенты для ФВЧ
    public static final double[] COEFS_OF_BAND_7 = { // 6
            1.6925001221429418E-6, 1.7836346149530422E-6, -3.371398859221378E-6, -4.63282252566612E-6,
            7.500503804766737E-6, 1.0166479197198687E-5, -1.464638052530088E-5, -2.007126359277932E-5,
            2.61857083023599E-5, 3.674807686694117E-5, -4.3837287437515535E-5, -6.349615592588396E-5,
            6.966332818460016E-5, 1.0471229050065441E-4, -1.060443002236599E-4, -1.660995692041895E-4,
            1.5562283329447453E-4, 2.5487984686336997E-4, -2.2121397370062623E-4, -3.8000520282441047E-4,
            3.056815086513962E-4, 5.523665761097298E-4, -4.117829285423223E-4, -7.850032139496241E-4,
            5.419886971156082E-4, 0.0010933255095695394, -6.982845788105881E-4, -0.0014953776685136609,
            8.819685375907862E-4, 0.0020121877797252383, -0.0010934558734785407, -0.0026682853834538397,
            0.0013321075288412177, 0.003492518049442206, -0.0015960966590680863, -0.004519383152999739,
            0.001882327487859712, 0.005791237361247267, -0.0021864181263544793, -0.0073620129173501666,
            0.002502755514102254, 0.00930358364815599, -0.0028246261414863437, -0.011716976723294126,
            0.0031444210459906667, 0.014752939467061847, -0.003453908129920073, -0.018651885424131553,
            0.0037445595663538056, 0.023827785144122503, -0.004007917396082103, -0.031064197798077262,
            0.0042359767927500755, 0.04204647746933035, -0.0044215642360584525, -0.06117106684273848,
            0.00455868722544705, 0.104590991426031, -0.0046428332969939475, -0.31780262522889874,
            0.5046708906409781, -0.31780262522889874, -0.0046428332969939475, 0.104590991426031,
            0.00455868722544705, -0.06117106684273848, -0.0044215642360584525, 0.04204647746933035,
            0.0042359767927500755, -0.031064197798077262, -0.004007917396082103, 0.023827785144122503,
            0.0037445595663538056, -0.018651885424131553, -0.003453908129920073, 0.014752939467061847,
            0.0031444210459906667, -0.011716976723294126, -0.0028246261414863437, 0.00930358364815599,
            0.002502755514102254, -0.0073620129173501666, -0.0021864181263544793, 0.005791237361247267,
            0.001882327487859712, -0.004519383152999739, -0.0015960966590680863, 0.003492518049442206,
            0.0013321075288412177, -0.0026682853834538397, -0.0010934558734785407, 0.0020121877797252383,
            8.819685375907862E-4, -0.0014953776685136609, -6.982845788105881E-4, 0.0010933255095695394,
            5.419886971156082E-4, -7.850032139496241E-4, -4.117829285423223E-4, 5.523665761097298E-4,
            3.056815086513962E-4, -3.8000520282441047E-4, -2.2121397370062623E-4, 2.5487984686336997E-4,
            1.5562283329447453E-4, -1.660995692041895E-4, -1.060443002236599E-4, 1.0471229050065441E-4,
            6.966332818460016E-5, -6.349615592588396E-5, -4.3837287437515535E-5, 3.674807686694117E-5,
            2.61857083023599E-5, -2.007126359277932E-5, -1.464638052530088E-5, 1.0166479197198687E-5,
            7.500503804766737E-6, -4.63282252566612E-6, -3.371398859221378E-6, 1.7836346149530422E-6,
            1.6925001221429418E-6
    };

    // информация о диапазонах частот для каждого фильтра
    public static final String INFO_BAND_0 ="LowPass 100 Hz";
    public static final String INFO_BAND_1 ="BandPass 100 - 259 Hz";
    public static final String INFO_BAND_2 ="BandPass 259 - 604 Hz";
    public static final String INFO_BAND_3 ="BandPass 604 - 1294 Hz";
    public static final String INFO_BAND_4 ="BandPass 1294 - 2675 Hz";
    public static final String INFO_BAND_5 ="BandPass 2675 - 5435 Hz";
    public static final String INFO_BAND_6 ="BandPass 5435 - 10957 Hz";
    public static final String INFO_BAND_7 ="BandPass 10957 - 22000 Hz";

}