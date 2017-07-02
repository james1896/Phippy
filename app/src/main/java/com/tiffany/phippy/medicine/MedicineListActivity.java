package com.tiffany.phippy.medicine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tiffany.phippy.BaseActivity;
import com.tiffany.phippy.R;
import com.tiffany.phippy.adapter.MedicineListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by moses on 17/06/2017.
 */

public class MedicineListActivity extends BaseActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicinelist);

        Intent intent = getIntent();
        final int page = intent.getIntExtra("com.tiffany.android_intent.age",0);
        ListView listView = (ListView)findViewById(R.id.medList_listview);
        listView.setAdapter(new MedicineListAdapter(this,getDataList(page)));

        TextView title = (TextView) findViewById(R.id.medList_title);
        title.setText(new String[]{"滋补调养","男科用药","风湿骨科","肠胃用药","维生素钙","五官用药","皮肤用药","妇儿用药","感冒发烧"}[page-1]);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ArrayList<Map> list = getDataList(page);

//                Map<String,Object> map = this.dataList.get(position);
                Map<String,Object> map = list.get(i);
                String titleS = (String) map.get("title");
                Toast.makeText(MedicineListActivity.this, titleS,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<Map> getDataList(int i){

        switch (i){
            case 1:
                return zibutiaoyang();
            case 2:
                return nankeyongyao();
            case 3:
                return fengshiguke();
            case 4:
                return changweiyongyao();
            case 5:
                return weishengsugai();
            case 6:
                return wuguanyongyao();
            case 7:
                return pifuyongyao();
            case 8:
                return fueryongyao();
            case 9:
                return ganmaoyongyao();

            default:
                return null;
        }
    }


    //  封装 数据
    private ArrayList<Map> ganmaoyongyao() {

        ArrayList<Map> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","云南白药小柴胡颗粒10g*6袋解表散热食欲不振口苦咽干");
        map1.put("resId",R.mipmap.ganmao_01);
        map1.put("price","₱ 140");
        list.add(map1);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","潘高寿蛇胆川贝液10ml*6支止咳糖浆 止咳化痰 咳嗽 痰多 气喘");
        map2.put("resId",R.mipmap.ganmao_02);
        map2.put("price","₱ 140");
        list.add(map2);

        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("title","水仙牌 风油精 9ml 清凉驱风止痒 防蚊虫头晕头痛药膏 外用");
        map3.put("resId",R.mipmap.ganmao_03);
        map3.put("price","₱ 50");
        list.add(map3);

        Map<String,Object> map4 = new HashMap<String,Object>();
        map4.put("title","三精 双黄连口服液10支 清热解毒 发热咽痛 感冒咳嗽药");
        map4.put("resId",R.mipmap.ganmao_04);
        map4.put("price","₱ 200");
        list.add(map4);

        Map<String,Object> map5 = new HashMap<String,Object>();
        map5.put("title","香港幸福科达琳(成人) 复方氨酚肾素片12片 伤风素鼻塞感冒药品");
        map5.put("resId",R.mipmap.ganmao_05);
        map5.put("price","₱ 299");
        list.add(map5);


        Map<String,Object> map6 = new HashMap<String,Object>();
        map6.put("title","999板蓝根颗粒20袋 清热解毒口咽干燥扁桃体发炎药品");
        map6.put("resId",R.mipmap.ganmao_06);
        map6.put("price","₱ 129");
        list.add(map6);

        Map<String,Object> map7 = new HashMap<String,Object>();
        map7.put("title","感康 复方氨酚烷胺片 16片/盒片剂吉林省吴太感康品牌疗效好.发热");
        map7.put("resId",R.mipmap.ganmao_07);
        map7.put("price","₱ 150");
        list.add(map7);

        Map<String,Object> map8 = new HashMap<String,Object>();
        map8.put("title","999 感冒灵颗粒三九冲剂 感冒药咳嗽药流涕感冒鼻塞头痛");
        map8.put("resId",R.mipmap.ganmao_08);
        map8.put("price","₱ 120");
        list.add(map8);

        Map<String,Object> map9 = new HashMap<String,Object>();
        map9.put("title","正头孢拉定胶囊 0.25g*24粒/盒");
        map9.put("resId",R.mipmap.ganmao_09);
        map9.put("price","₱ 86");
        list.add(map9);

        Map<String,Object> map10 = new HashMap<String,Object>();
        map10.put("title","阿莫西林胶囊");
        map10.put("resId",R.mipmap.ganmao_10);
        map10.put("price","₱ 161");
        list.add(map10);
        return list;

    }

    private ArrayList<Map> fueryongyao() {
        ArrayList<Map> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","NANA TAKA 维他命C+ZINC Jelly乳酸钙DHA儿童锌钙糖150g");
        map1.put("resId",R.mipmap.yuner_01);
        map1.put("price","₱ 1440");
        list.add(map1);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","NANA TAKA Bilberry DHA chews 蓝莓营养果汁软糖150g");
        map2.put("resId",R.mipmap.yuner_02);
        map2.put("price","₱ 1440");
        list.add(map2);

        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("title","三精牌葡萄糖酸钙口服液12支蓝瓶儿童妇女老人孕妇补钙");
        map3.put("resId",R.mipmap.yuner_03);
        map3.put("price","₱ 250");
        list.add(map3);

        Map<String,Object> map4 = new HashMap<String,Object>();
        map4.put("title","亚宝丁桂儿脐贴2贴小儿腹泻宝宝一贴灵肚脐贴 健脾散寒止泻药品");
        map4.put("resId",R.mipmap.yuner_04);
        map4.put("price","₱ 150");
        list.add(map4);

        Map<String,Object> map5 = new HashMap<String,Object>();
        map5.put("title","同仁堂益母草颗粒8袋活血调经 月经不调 量少调经药品");
        map5.put("resId",R.mipmap.yuner_05);
        map5.put("price","₱ 160");
        list.add(map5);


        Map<String,Object> map6 = new HashMap<String,Object>();
        map6.put("title","同仁堂 乌鸡白凤丸10丸*1盒 月经不调 补气养血 调经止带行经腹痛");
        map6.put("resId",R.mipmap.yuner_06);
        map6.put("price","₱ 150");
        list.add(map6);

        Map<String,Object> map7 = new HashMap<String,Object>();
        map7.put("title","正品保证 金毓婷 左炔诺孕酮片避孕药 1片装 短效避孕药");
        map7.put("resId",R.mipmap.yuner_07);
        map7.put("price","₱ 360");
        list.add(map7);

        Map<String,Object> map8 = new HashMap<String,Object>();
        map8.put("title","恩威 洁尔阴洗液280ml品牌疗效好.具有清热解毒祛风除湿带下量多");
        map8.put("resId",R.mipmap.yuner_08);
        map8.put("price","₱ 300");
        list.add(map8);

        Map<String,Object> map9 = new HashMap<String,Object>();
        map9.put("title","正品保证 避孕药 丹媚左炔诺孕酮肠溶片1片 短效避孕药");
        map9.put("resId",R.mipmap.yuner_09);
        map9.put("price","₱ 460");
        list.add(map9);

        Map<String,Object> map10 = new HashMap<String,Object>();
        map10.put("title","仙琚 左炔诺孕酮肠溶胶囊 1粒 紧急避孕 72小时避孕药");
        map10.put("resId",R.mipmap.yuner_10);
        map10.put("price","₱ 390");
        list.add(map10);
        return list;
    }

    private ArrayList<Map> weishengsugai() {
        ArrayList<Map> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","汤臣倍健 多种维生素矿物质片(男士型) 1.5g/片*60片");
        map1.put("resId",R.mipmap.weishengsu_01);
        map1.put("price","₱ 950");

        list.add(map1);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","汤臣倍健 多种维生素矿物质片（女士型） 1.5g/片*60片");
        map2.put("resId",R.mipmap.weishengsu_02);
        map2.put("price","₱ 950");
        list.add(map2);

        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("title","汤臣倍健天然维生素E软胶囊 500mg/粒*60粒");
        map3.put("resId",R.mipmap.weishengsu_03);
        map3.put("price","₱ 950");
        list.add(map3);

        Map<String,Object> map4 = new HashMap<String,Object>();
        map4.put("title","汤臣倍健牌维生素B族片 550mg/片*100片/瓶");
        map4.put("resId",R.mipmap.weishengsu_04);
        map4.put("price","₱ 1200");
        list.add(map4);

        Map<String,Object> map5 = new HashMap<String,Object>();
        map5.put("title","汤臣倍健牌维生素C片 600mg/片*100片");
        map5.put("resId",R.mipmap.weishengsu_05);
        map5.put("price","₱ 950");
        list.add(map5);

        Map<String,Object> map6 = new HashMap<String,Object>();
        map6.put("title","养生堂牌天然维生素C咀嚼片 850mg/片*130片 增强免疫力");
        map6.put("resId",R.mipmap.weishengsu_06);
        map6.put("price","₱ 1350");
        list.add(map6);

        Map<String,Object> map7 = new HashMap<String,Object>();
        map7.put("title","养生堂牌天然维生素E软胶囊 250mg/粒*200粒 祛黄褐斑 延缓衰老");
        map7.put("resId",R.mipmap.weishengsu_07);
        map7.put("price","₱ 1300");
        list.add(map7);


        return list;

    }

    private ArrayList<Map> pifuyongyao() {

        ArrayList<Map> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","九芝堂足光散 40g*5包 去脚气脚臭足癣足光粉脚癣泡脚脚汗药品");
        map1.put("resId",R.mipmap.pifu_01);
        map1.put("price","₱ 140");
        list.add(map1);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","京万红软膏 20g支 活血解毒消肿止痛 烫伤肿痛 创面溃烂");
        map2.put("resId",R.mipmap.pifu_02);
        map2.put("price","₱ 160");
        list.add(map2);

        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("title","三九 999皮炎平 复方醋酸地塞米松乳膏30g 皮肤瘙痒 皮炎 湿疹");
        map3.put("resId",R.mipmap.pifu_03);
        map3.put("price","₱ 110");
        list.add(map3);

        Map<String,Object> map4 = new HashMap<String,Object>();
        map4.put("title","派瑞松 曲安奈德益康唑乳膏15g 皮肤癣真菌感染皮炎湿疹软膏");
        map4.put("resId",R.mipmap.pifu_04);
        map4.put("price","₱ 185");
        list.add(map4);

        Map<String,Object> map5 = new HashMap<String,Object>();
        map5.put("title","达克宁 软膏 硝酸咪康唑乳膏20g 治脚气膏 脚痒 手足癣药膏药品");
        map5.put("resId",R.mipmap.pifu_05);
        map5.put("price","₱ 168");
        list.add(map5);


        Map<String,Object> map6 = new HashMap<String,Object>();
        map6.put("title","神奇 珊瑚癣净250ml 除脚气去脚臭脚痒脱皮杀菌足癣灰指甲泡脚药");
        map6.put("resId",R.mipmap.pifu_06);
        map6.put("price","₱ 195");
        list.add(map6);

        Map<String,Object> map7 = new HashMap<String,Object>();
        map7.put("title","百多邦 莫匹罗星软膏10克 感染发炎脓疱湿疹毛囊炎脓胞 中美史克");
        map7.put("resId",R.mipmap.pifu_07);
        map7.put("price","₱ 225");
        list.add(map7);

        Map<String,Object> map8 = new HashMap<String,Object>();
        map8.put("title","马应龙 马应龙麝香痔疮栓*12粒装马应龙药业栓剂大品牌疗效好内疮");
        map8.put("resId",R.mipmap.pifu_08);
        map8.put("price","₱ 139");
        list.add(map8);

        Map<String,Object> map9 = new HashMap<String,Object>();
        map9.put("title","马应龙 痔疮膏 10g 麝香痔疮药 大便出血 治疗痔疮");
        map9.put("resId",R.mipmap.pifu_09);
        map9.put("price","₱ 109");
        list.add(map9);

        Map<String,Object> map10 = new HashMap<String,Object>();
        map10.put("title","康王 复方酮康唑发用洗剂5ml 脂溢性皮炎 去屑止痒洗发水");
        map10.put("resId",R.mipmap.pifu_10);
        map10.put("price","₱ 36");
        list.add(map10);
        return list;

    }

    private ArrayList<Map> wuguanyongyao() {
        ArrayList<Map> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","日本进口龙角散润喉糖咳嗽化痰咽喉肿痛润喉清凉糖袋装龙角散糖果");
        map1.put("resId",R.mipmap.wuguan_01);
        map1.put("price","₱ 260");
        list.add(map1);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","开瑞坦 氯雷他定片 6片 皮肤瘙痒过敏性鼻炎鼻塞");
        map2.put("resId",R.mipmap.wuguan_02);
        map2.put("price","₱ 200");
        list.add(map2);

        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("title","京都念慈菴枇杷润喉糖");
        map3.put("resId",R.mipmap.wuguan_03);
        map3.put("price","₱ 150");
        list.add(map3);

        Map<String,Object> map4 = new HashMap<String,Object>();
        map4.put("title","同仁堂 牛黄解毒片 0.27g*120片/盒");
        map4.put("resId",R.mipmap.wuguan_04);
        map4.put("price","₱ 160");
        list.add(map4);

        Map<String,Object> map5 = new HashMap<String,Object>();
        map5.put("title","辰欣 红霉素眼膏 0.5%*2g*1支/盒 沙眼 结膜炎 眼外部感染");
        map5.put("resId",R.mipmap.wuguan_05);
        map5.put("price","₱ 50");
        list.add(map5);

        Map<String,Object> map6 = new HashMap<String,Object>();
        map6.put("title","恒健红霉素软膏 10g 抗菌消炎祛痘去痤疮乳膏治皮肤病药");
        map6.put("resId",R.mipmap.wuguan_06);
        map6.put("price","₱ 50");
        list.add(map6);

        Map<String,Object> map7 = new HashMap<String,Object>();
        map7.put("title","日本kirindo Sante FX NEO清凉型眼药水12mL缓解眼部疲劳充血");
        map7.put("resId",R.mipmap.wuguan_07);
        map7.put("price","₱ 500");
        list.add(map7);

        Map<String,Object> map8 = new HashMap<String,Object>();
        map8.put("title","都乐广西金嗓子喉片喉宝12片咽喉肿声音嘶哑急性咽炎药品");
        map8.put("resId",R.mipmap.wuguan_08);
        map8.put("price","₱ 100");
        list.add(map8);
        return list;
    }

    private ArrayList<Map> changweiyongyao() {

        ArrayList<Map> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","江中牌健胃消食片 32片 健胃消食 治脾胃虚弱 消化不良");
        map1.put("resId",R.mipmap.changwei_01);
        map1.put("price","₱ 100");
        list.add(map1);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","维仙优复方维生素U片30片胃病胃痛酸消化不良胃胀气胃仙u日本胃药");
        map2.put("resId",R.mipmap.changwei_02);
        map2.put("price","₱ 400");
        list.add(map2);

        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("title","康恩贝 肠炎宁片48片 腹痛腹泻腹胀 用于急慢性胃肠炎药品");
        map3.put("resId",R.mipmap.changwei_03);
        map3.put("price","₱ 250");
        list.add(map3);

        Map<String,Object> map4 = new HashMap<String,Object>();
        map4.put("title","吗丁啉多潘立酮30片胃动力肠胃胀气 消化不良 腹痛 腹胀 恶心呕吐");
        map4.put("resId",R.mipmap.changwei_04);
        map4.put("price","₱ 180");
        list.add(map4);

        Map<String,Object> map5 = new HashMap<String,Object>();
        map5.put("title","阿房宫 固肠止泻丸 216粒*1瓶/盒");
        map5.put("resId",R.mipmap.changwei_05);
        map5.put("price","₱ 190");
        list.add(map5);

        Map<String,Object> map6 = new HashMap<String,Object>();
        map6.put("title","999三九胃泰颗粒10袋消炎止痛胃痛胃酸胃胀反酸恶心呕吐胃炎胃药");
        map6.put("resId",R.mipmap.changwei_06);
        map6.put("price","₱ 101");
        list.add(map6);

        Map<String,Object> map7 = new HashMap<String,Object>();
        map7.put("title","盘龙云海 品牌 排毒养颜胶囊70粒盒益气活血祛斑通便");
        map7.put("resId",R.mipmap.changwei_07);
        map7.put("price","₱ 776");
        list.add(map7);

        Map<String,Object> map8 = new HashMap<String,Object>();
        map8.put("title","康恩贝 金奥康 奥美拉唑肠溶胶囊 20mg*14粒/盒");
        map8.put("resId",R.mipmap.changwei_08);
        map8.put("price","₱ 645");
        list.add(map8);
        return list;

    }

    private ArrayList<Map> fengshiguke() {
        ArrayList<Map> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","云南白药气雾剂 50g+60g喷雾剂消肿化淤跌打扭伤止痛风湿疼痛药");
        map1.put("resId",R.mipmap.fengshi_01);
        map1.put("price","₱ 299");

        list.add(map1);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","路林 双氯芬酸钠缓释片 0.1g*24片/盒");
        map2.put("resId",R.mipmap.fengshi_02);
        map2.put("price","₱ 191");

        list.add(map2);


        return list;


    }

    private ArrayList<Map> nankeyongyao(){
        ArrayList<Map> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","万艾可 枸橼酸西地那非片 0.1g*1片/盒");
        map1.put("resId",R.mipmap.nanke_01);
        map1.put("price","₱ 1008");
        list.add(map1);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","太极 生力雄丸 12粒*2板/盒");
        map2.put("resId",R.mipmap.nanke_02);
        map2.put("price","₱ 580");
        list.add(map2);

        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("title","日本进口冈本001安全套超薄0.01避孕套 幸福的001防过敏003只装");
        map3.put("resId",R.mipmap.nanke_03);
        map3.put("price","₱ 650");
        list.add(map3);

        Map<String,Object> map4 = new HashMap<String,Object>();
        map4.put("title","京果海狗丸120粒男性肾虚男 补肾壮阳延时腰膝酸软尿频药品");
        map4.put("resId",R.mipmap.nanke_04);
        map4.put("price","₱ 1008");
        list.add(map4);

        Map<String,Object> map5 = new HashMap<String,Object>();
        map5.put("title","同仁堂五子衍宗丸60g 肾虚 阳痿不育 补肾早泄 药品");
        map5.put("resId",R.mipmap.nanke_05);
        map5.put("price","₱ 160");
        list.add(map5);

        Map<String,Object> map6 = new HashMap<String,Object>();
        map6.put("title","汇仁牌肾宝片126片腰腿酸痛温阳肾虚夜尿");
        map6.put("resId",R.mipmap.nanke_06);
        map6.put("price","₱ 2600");
        list.add(map6);
        return list;
    }

    //
    private ArrayList<Map> zibutiaoyang(){
        ArrayList<Map> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","银耳 易糯多胶 原色白木耳 无硫");
        map1.put("resId",R.mipmap.zibu_01);
        map1.put("price","₱ 280");

        list.add(map1);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","精选特级无核大桂圆肉500g 广西特产");
        map2.put("resId",R.mipmap.zibu_02);
        map2.put("price","₱ 450");

        list.add(map2);

        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("title","宁夏枸杞250g 养肝明目、补气强精");
        map3.put("resId",R.mipmap.zibu_03);
        map3.put("price","₱ 200");
        list.add(map3);

        Map<String,Object> map4 = new HashMap<String,Object>();
        map4.put("title","杭白菊 花茶50g袋装 胎菊去火");
        map4.put("resId",R.mipmap.zibu_04);
        map4.put("price","₱ 150");
        list.add(map4);

        Map<String,Object> map5 = new HashMap<String,Object>();
        map5.put("title","东阿阿胶 复方阿胶浆20ml*48支 口服液补血补气贫血 药");
        map5.put("resId",R.mipmap.zibu_05);
        map5.put("price","₱ 3600");
        list.add(map5);

        Map<String,Object> map6 = new HashMap<String,Object>();
        map6.put("title","吉林敖东安神补脑液口服液10支治疗失眠多梦神经衰弱健忘安眠");
        map6.put("resId",R.mipmap.zibu_06);
        map6.put("price","₱ 220");
        list.add(map6);

        Map<String,Object> map7 = new HashMap<String,Object>();
        map7.put("title","北京同仁堂六味地黄丸360粒水蜜丸男女滋阴补肾头晕耳鸣盗");
        map7.put("resId",R.mipmap.zibu_07);
        map7.put("price","₱ 150");
        list.add(map7);


        Map<String,Object> map8 = new HashMap<String,Object>();
        map8.put("title","山东东阿阿胶250g铁盒补血、滋阴润燥");
        map8.put("resId",R.mipmap.zibu_08);
        map8.put("price","₱ 9586");
        list.add(map8);

        return list;
    }


}
