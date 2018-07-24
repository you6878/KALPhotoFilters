package com.howl.howlphotofilter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.R.attr.process
import com.zomato.photofilters.SampleFilters
import android.R.attr.process
import com.zomato.photofilters.geometry.Point
import com.zomato.photofilters.imageprocessors.Filter
import com.zomato.photofilters.imageprocessors.subfilters.ToneCurveSubfilter
import android.R.attr.process
import com.zomato.photofilters.imageprocessors.subfilters.SaturationSubfilter
import android.R.attr.process
import com.zomato.photofilters.imageprocessors.subfilters.ColorOverlaySubfilter
import android.R.attr.process
import com.zomato.photofilters.imageprocessors.subfilters.ContrastSubfilter
import android.R.attr.process
import com.zomato.photofilters.imageprocessors.subfilters.BrightnessSubfilter
import com.zomato.photofilters.imageprocessors.subfilters.VignetteSubfilter















class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        System.loadLibrary("NativeImageProcessor")
        button.setOnClickListener {
            var bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources,R.drawable.tomato),imageView.measuredWidth,imageView.measuredHeight,false)
            val fooFilter = SampleFilters.getBlueMessFilter()
            val outputImage = fooFilter.processFilter(bitmap)
            imageView.setImageBitmap(outputImage)
        }
        button2.setOnClickListener {

            var bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources,R.drawable.tomato),imageView.measuredWidth,imageView.measuredHeight,false)
            val myFilter = Filter()
            val rgbKnots = arrayOfNulls<Point>(3)
            rgbKnots[0] = Point(0f, 0f)
            rgbKnots[1] = Point(175f, 139f)
            rgbKnots[2] = Point(255f, 255f)

            myFilter.addSubFilter(ToneCurveSubfilter(rgbKnots, null, null, null))
            val outputImage = myFilter.processFilter(bitmap)
            imageView.setImageBitmap(outputImage)
        }
        button3.setOnClickListener {
            var bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources,R.drawable.tomato),imageView.measuredWidth,imageView.measuredHeight,false)
            val myFilter = Filter()
            myFilter.addSubFilter(SaturationSubfilter(1.3f))
            val outputImage = myFilter.processFilter(bitmap)
            imageView.setImageBitmap(outputImage)
        }
        button4.setOnClickListener {
            var bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources,R.drawable.tomato),imageView.measuredWidth,imageView.measuredHeight,false)
            val myFilter = Filter()
            myFilter.addSubFilter(ColorOverlaySubfilter(100, .2f, .2f, .0f))
            val outputImage = myFilter.processFilter(bitmap)
            imageView.setImageBitmap(outputImage)
        }
        button5.setOnClickListener {
            var bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources,R.drawable.tomato),imageView.measuredWidth,imageView.measuredHeight,false)
            val myFilter = Filter()
            myFilter.addSubFilter(ContrastSubfilter(1.2f))
            val outputImage = myFilter.processFilter(bitmap)
            imageView.setImageBitmap(outputImage)
        }
        button6.setOnClickListener {
            var bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources,R.drawable.tomato),imageView.measuredWidth,imageView.measuredHeight,false)
            val myFilter = Filter()
            myFilter.addSubFilter(BrightnessSubfilter(30))
            myFilter.addSubFilter(VignetteSubfilter(this, 100))
            val ouputImage = myFilter.processFilter(bitmap)
            imageView.setImageBitmap(ouputImage)
        }
    }
}
