# AndroidDataBinding

something about Android Data Binding based on Data Binding Guide

本文是跟着 官网Data Binding Guide 学习过程中得出的一些实践经验，希望对各位有所帮助

1.准备

新建一个 Project，确保 Android 的 Gradle 插件版本不低于 1.5.0-alpha1：

classpath 'com.android.tools.build:gradle:1.5.0'
然后修改对应模块（Module）的 build.gradle：

dataBinding {
    enabled true
}
2.基础

工程创建完成后，我们通过一个最简单的例子来说明 Data Binding 的基本用法。

3.布局文件

使用 Data Binding 之后，xml 的布局文件就不再用于单纯地展示 UI 元素，还需要定义 UI 元素用到的变量。所以，它的根节点不再是一个 ViewGroup，而是变成了 layout，并且新增了一个节点 data。

<layout xmlns:android="http://schemas.android.com/apk/res/android">
    <data>
    </data>
    <!--原先的根节点（Root Element）-->
    <LinearLayout>
    ....
    </LinearLayout>
</layout>
要实现 MVVM 的 ViewModel 就需要把数据（Model）与 UI（View） 进行绑定，data 节点的作用就像一个桥梁，搭建了 View 和 Model 之间的通路。

我们先在 xml 布局文件的 data 节点中声明一个 variable，这个变量会为 UI 元素提供数据（例如 TextView 的 android:text），然后在 Java 代码中把『后台』数据与这个 variable 进行绑定。

下面我们使用 Data Binding 创建一个展示用户信息的表格。

4.数据对象

新建一个User类，包含name和age属性，很简单；

5.定义 Variable

回到布局文件，在 data 节点中声明一个 User 类型的变量 user。

<data>
    <variable name="user" type="com.liangfeizc.databindingsamples.basic.User" />
</data>
其中 type 属性就是我们在 Java 文件中定义的 User 类。

当然，data 节点也支持 import，所以上面的代码可以换一种形式来写。

<data>
    <import type="dbh.leo.com.databinding.entity.User" />
    <variable name="user" type="User" />
</data>
然后我们刚才在 build.gradle 中添加的那个插件 - com.android.databinding 会根据 xml 文件的名称 Generate 一个继承自 ViewDataBinding 的类。 当然，IDE 中看不到这个文件，需要手动去 build 目录下找。

6.绑定 Variable

修改 BasicActivity 的 onCreate 方法，用 DatabindingUtil.setContentView() 来替换掉 setContentView()，然后创建一个 user 对象，通过 binding.setUser(user) 与 variable 进行绑定。

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    user = new User("Test", 28);
    activityMainBinding.setUser(user);
}


7.使用 Variable

数据与 Variable 绑定之后，xml 的 UI 元素就可以直接使用了。

<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@{user.name}" />
至此，一个简单的数据绑定就完成了;是不是很简单呢；


8.binding events

你可能已经看到了，像普通的写法一样，可以给控件添加点击长按等事件，然后再在MainActivity中定义该方法并实现具体逻辑；其他很多属性都可以这样使用，比如说是tag等

<Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginTop="@dimen/dimen_30"
    android:gravity="center"
    android:onClick="btnUpdate"
    android:tag="@{observableUser.name + observableUser.age}"
    android:text="update"
    android:textColor="@color/colorAccent"
    android:textSize="22sp" />
