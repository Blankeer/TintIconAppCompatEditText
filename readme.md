#icon着色的AppCompatEditText
minSdkVersion 9

使用:
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        compile 'com.github.Blankeer:TintIconAppCompatEditText:0.1'
	}

```xml
    <com.blanke.lib.TintIconAppCompatEditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:drawableLeft="@drawable/ic_msg"
        app:focusIconTintColor="@color/colorPrimary"
        app:unFocusIconTintColor="#777"/>
```

6.0----4.4---2.3.7

![gif](https://raw.githubusercontent.com/Blankeer/TintIconAppCompatEditText/master/image/tint.gif)

