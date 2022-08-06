package kr.co.hanbit.customtext

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CustomText: AppCompatTextView {
    /* delimeter와 입력된 값을 조합해서 처리하는 함수 */
    fun process(delimeter: String) {
        var one = text.substring(0,4) //year
        var two = text.substring(4,6) //month
        var three = text.substring(6) //day

        setText("$one $delimeter $two $delimeter $three")
    }

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val typed = context.obtainStyledAttributes(attrs, R.styleable.CustomText) // res/values/attrs.xml에 정의된 어트리뷰트 가져오기
        val size = typed.indexCount

        for (i in 0 until size) {
            when (typed.getIndex(i)) {
                R.styleable.CustomText_delimeter -> { //현재 속성을 확인하고 delimeter와 같으면
                    val delimeter = typed.getString(typed.getIndex(i)) ?: "-" //xml에 입력된 delimeter 값을 꺼내고 (defalut는 "-")
                    process(delimeter) //꺼낸 값을 process() 메서드에 넘겨서 처리
                }
            }
        }
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr) {
    }
}