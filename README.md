# IndicatorView
以前在项目中使用线性布局实现该效果，感觉操作很繁琐而且很不利于复用，于是封装了一个简单的指示器类。
这是一个非常简单的ViewPager页码指示器，实现方式只有一个继承View的自定义View。

IndicatorView主要使用场景如下：

- 引导页页码指示
- 轮播图页码指示



## 快速使用

### 1.引入依赖

使用Android Studio

在build.gradle中添加如下代码：
```
dependencies {
     compile 'cn.junhua.android.view:indicatorviewlibrary:1.0.0'
}
```


### 2.在布局文件引入IndicatorView

```xml
<cn.junhua.android.view.IndicatorView
            android:id="@+id/indicator_view"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>
```

这是最简单的使用方法，默认样式如下图：

![IndicatorView default](https://github.com/JunhuaLin/IndicatorView/blob/master/photo/indicatorview_default.png)

IndicatorView支持的自定义属性如下：

```xml
<declare-styleable name="IndicatorView">

        <!-- 设置指示器显示的总个数 -->
        <attr name="indicator_count" format="integer" />
        <!-- 指示器绘图的默认颜色 -->
        <attr name="indicator_color" format="reference|color" />
        <!-- 指示器绘图的select形式，会覆盖indicator_color设置的值-->
        <attr name="indicator_drawable" format="reference" />
        <!-- 指示器绘图的半径 -->
        <attr name="indicator_radius" format="reference|dimension" />
        <!-- 指示器绘图的选中时放缩比例 -->
        <attr name="indicator_select_scale" format="float" />
        <!-- 指示器默认选中的单元 -->
        <attr name="indicator_select" format="integer" />
    </declare-styleable>
```

例如indicator_drawable属性支持StateListDrawable类型选择器，IndicatorView会根据不同的条件展示不同到图形。
支持如下几对的触发条件：
* state_selected
* state_pressed
* state_checked
* state_enabled

使用方式：

indicator_unit_select1.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:state_pressed="false">
        <shape android:shape="oval">
            <solid android:color="#ff0000" />
        </shape>
    </item>
    <item android:state_pressed="true">
        <shape android:shape="oval">
            <stroke android:width="1dp" android:color="#ff0000" />
        </shape>
    </item>
</selector>
```

布局文件
```xml
<cn.junhua.android.view.IndicatorView
            android:id="@+id/indicator_view1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            app:indicator_count="9"
            app:indicator_drawable="@drawable/indicator_unit_select1"
            app:indicator_select="0" />
```

运行效果如下：

![IndicatorView1](https://github.com/JunhuaLin/IndicatorView/blob/master/photo/indicatorview1.png)


### 3.在代码中关联IndicatorView

a.初始化
```java
IndicatorView indicator_view = (IndicatorView) findViewById(R.id.indicator_view);
indicator_view.setCount(resList.size());
...
```

b.关联ViewPager

```java
...
viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                indicator_view.setSelect(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    ...
```

### 4.效果集合

不同到选择效果都可以通过不同到选择器得到。

![IndicatorView1](https://github.com/JunhuaLin/IndicatorView/blob/master/photo/indicatorview2.png)



