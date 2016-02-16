# TestScrollViewListView

## ScrollView中嵌套ListView，仿美团首页

ScrollView中嵌套ListView往往会使数据显示不全，需要重写ListView的onMeasure方法

	public class MyListView extends ListView {
	    
	    public MyListView(Context context) {
	        super(context);
	    }
	
	    public MyListView(Context context, AttributeSet attrs) {
	        super(context, attrs);
	    }
	
	    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	    }
	
	    @Override
	    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
	        super.onMeasure(widthMeasureSpec, expandSpec);
	    }
	}
	
问题一 ： 嵌套在 ScrollView的 ListVew数据显示不全，我遇到的是最多只显示两条已有的数据。

解决办法：重写 ListVew或者 GridView，网上还有很多若干解决办法，但是都不好用或者很复杂。

	@Override
	
	/**   只重写该方法，达到使ListView适应ScrollView的效果   */ 
	
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	
	int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
	
	super.onMeasure(widthMeasureSpec, expandSpec);
	
	}

问题二 、打开套有 ListVew的 ScrollView的页面布局 默认 起始位置不是最顶部。

解决办法有两种都挺好用：

一是把套在里面的Gridview 或者 ListVew 不让获取焦点即可。

`gridview.setFocusable(false); `

`listview.setFocusable(false);`

注意：在xml布局里面设置`android：focusable=“false”`不生效

方法二：网上还查到说可以设置`myScrollView.smoothScrollTo(0,0);`