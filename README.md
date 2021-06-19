# Swipe To Reply
This is a small library that can be used to implement a  "swipe-to-reply" functionality in your Android apps
Made on the basis of https://github.com/izjumovfs/SwipeToReply, in contrast to which, the swipe is to the left, which is much more convenient and familiar.

Here's what it looks like:

![Output sample](https://s6.gifyu.com/images/ezgif.com-gif-maker99c9076f11ce89f4.gif)

## Usage

How to

To get a Git project into your build:

Step 1. Add it in your root build.gradle at the end of repositories:
```Java
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Step 2. Add the dependency
```Java
dependencies {
       implementation 'com.github.Std1o:SwipeToReply:0.0.1'
}
```

#### Java

```Java
SwipeController controller = new SwipeController(context, new ISwipeControllerActions() {
                @Override
                public void onSwipePerformed(int position) {
                      // Here you can handle the swipe-to-reply event
                }
            });
            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(controller);
            itemTouchHelper.attachToRecyclerView(recyclerView);
```
