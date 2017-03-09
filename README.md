# IndicatorView
这是一个非常简单的ViewPager页码指示器，它到实现只有一个继承View到自定义View。IndicatorView主要使用场景如下：

1. 引导页页码指示
2. 轮播图页码指示

以前在项目中使用线性布局实现该效果，感觉操作很繁琐而且很不利于复用，于是封装了一个简单的指示器类。

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

这是最简单到使用方法，默认样式如下图：

![IndicatorView default](https://github.com/JunhuaLin/IndicatorView/tree/master/photo/indicatorview_default.png)

