# MainEcommerceProject
This is main evaly ecommerce android project


Fragment to activity animations:-

 startActivity(new Intent(getActivity(), SubCatagories.class));
//  * below animation for fragment to activity.
((Activity) getActivity()).overridePendingTransition(R.animator.enter_from_right, R.animator.exit_to_left);

enter_from_right.xml = 

<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:shareInterpolator="false">
    <translate
        android:fromXDelta="100%" android:toXDelta="0%"
        android:fromYDelta="0%" android:toYDelta="0%"
        android:duration="500" />
</set>


R.animator.exit_to_left.xml = 

<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:shareInterpolator="false">
    <translate
        android:fromXDelta="0%" android:toXDelta="-100%"
        android:fromYDelta="0%" android:toYDelta="0%"
        android:duration="500"/>
</set>
