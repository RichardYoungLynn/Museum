package com.example.dell.museum3;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class IntroductionActivity extends AppCompatActivity {

    public static final String INTRODUCTION_CONTENT="      安徽省博物馆成立于1956年11 月14日，2010年12月28日更名为安徽博物院。" +"\n"+
            "      1958年9月17日，毛泽东同志视察安徽省博物馆并发表了重要讲话：一个省的主要城市，都应该有这样的博物馆，人民认识自己的历史和创造的力量是一件很要紧的事。这一讲话，既是对安徽省博物馆和安徽文物工作的肯定，也为新中国博物馆事业指明了发展方向。周恩来、刘少奇、朱德、邓小平、李先念、叶剑英、彭德怀、陈毅等老一辈党和国家领导人先后来馆视察，陈毅同志题写了馆名。" +"\n"+
            "      安徽博物院现为一院两馆运行模式。老馆位于合肥市安庆路268号，展陈大楼为仿苏式建筑，2013年入选第七批全国重点文物保护单位，常设展览有“安徽革命史陈列”“安徽古生物陈列”“安徽好人馆”等。新馆位于合肥市怀宁路268号，建筑造型体现了五方相连、四水归堂的徽派建筑风格，2011年9月29日建成并对外开放，常设展览有“安徽文明史陈列”以及“徽州古建筑”“安徽文房四宝” “江淮撷珍”“欧豪年美术馆”等专题。两馆每年还引进、举办多场展现境内外代表性历史文化风貌的精品临展，以满足观众多样化的文化需求。" +"\n"+
            "      安徽博物院现藏文物近22万件套，特色藏品包括商周青铜器、汉代画像石、古代陶瓷器、宋元金银器、文房四宝、明清书画、徽州雕刻、古籍善本、契约文书、近现代文物及潘玉良美术作品等。古旧字画装裱修复、青铜器保护修复、碑刻保护拓片等技术力量雄厚，在漆木器保护、油画保护修复、文物预防性保护方面具备一定实力。" +"\n"+
            "      建馆以来，安徽博物院以文物资源为基础，陈列展览为平台，文保科研为推力，宣教服务为保障，跻身国家一级博物馆行列，获评全国爱国主义教育基地、全国古籍重点保护单位、全国科普教育基地、全国首批公共文化设施学雷锋志愿服务示范单位等。“徽州古建筑陈列” “皖风徽韵——安徽历史文化陈列”“明德至善 家国天下——徽州优秀传统文化展”分别荣获第七届、第十届、第十三届全国博物馆十大陈列展览精品奖。" +"\n"+
            "      如今，安徽博物院不仅是文物收藏、保护和展示场所，还在求索中形成现代博物馆功能多元化、服务人性化的发展特色：“画魂玉良”“文房雅集”“青铜古韵”等9大系列上千种文创产品琳琅满目，实现公众把博物馆带回家的愿望；“安徽文博讲堂”“爱上博物馆”“安博之友”等各类讲座和文化体验活动，深入浅出、寓教于乐，吸引观众多渠道深度了解博物馆文化；互联网+时代，安徽博物院“两微一端一站”让人足不出户，轻点手机和电脑，便可以浏览精彩展览和精美藏品……" +"\n"+
            "      让历史不再遥远，让文明变得亲近，让文化走进生活，安徽博物院正在不断创新、不断探索，在建设共有精神家园的征程中，继往开来，铿锵前行。";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        Toolbar toolbar=(Toolbar)findViewById(R.id.introduction_toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.introduction_collapsing_toolbar);
        ImageView introductionImageView=(ImageView)findViewById(R.id.introduction_image_view);
        TextView introductionContentText=(TextView)findViewById(R.id.introduction_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle("博物馆概况");
        Glide.with(this).load(R.drawable.introduction).into(introductionImageView);
        introductionContentText.setText(INTRODUCTION_CONTENT);
        introductionContentText.setTextSize(20);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}