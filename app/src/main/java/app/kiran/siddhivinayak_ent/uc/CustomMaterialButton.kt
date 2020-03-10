package app.kiran.siddhivinayak_ent.uc

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import app.kiran.siddhivinayak_ent.R
import app.kiran.siddhivinayak_ent.utils.Constant
import com.google.android.material.button.MaterialButton

class CustomMaterialButton : MaterialButton {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {

        attrs?.let {

            val attribute: TypedArray =
                context!!.obtainStyledAttributes(attrs, R.styleable.CustomView)
            val fontTag = attribute.getInt(R.styleable.CustomView_custom_font, 0)
            setFont(context, fontTag, this)
            attribute.recycle()

        }

    }

    fun setFont(context: Context?, tag: Int, textView: TextView) {
        var typeface: Typeface? = null
        when (tag) {
            Constant.LIGHT -> {
                typeface = Typeface.createFromAsset(context!!.assets, "font/OpenSans-Light.ttf")
            }

            Constant.REGULAR -> {
                typeface = Typeface.createFromAsset(context!!.assets, "font/OpenSans-Regular.ttf")
            }

            Constant.SEMI_BOLD -> {
                typeface = Typeface.createFromAsset(context!!.assets, "font/OpenSans-SemiBold.ttf")
            }

            Constant.BOLD -> {
                typeface = Typeface.createFromAsset(context!!.assets, "font/OpenSans-Bold.ttf")
            }
            Constant.EXTRABOLD -> {
                typeface = Typeface.createFromAsset(context!!.assets, "font/OpenSans-ExtraBold.ttf")
            }
        }
        textView.setTypeface(typeface)

    }
}