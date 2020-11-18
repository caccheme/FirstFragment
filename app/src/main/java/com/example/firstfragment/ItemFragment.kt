package com.example.firstfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.text.NumberFormat


class ItemFragment : Fragment() {

    private var mProduct: Product? = null
    private val PRODUCT_KEY = "product key"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater
            .inflate(R.layout.fragment_detail, container, false) as ViewGroup

        val args: Bundle = arguments ?: throw AssertionError()

        mProduct = args.getParcelable(PRODUCT_KEY)
        mProduct ?: throw AssertionError()

//      display text and image
        val nameText = rootView.findViewById<View>(R.id.nameText) as TextView
        if (mProduct != null) {
            nameText.text = mProduct!!.name
        }
        val descriptionText = rootView.findViewById<View>(R.id.descriptionText) as TextView
        descriptionText.text = mProduct!!.getDescription()

        val formatter = NumberFormat.getCurrencyInstance()
        val price: String = formatter.format(mProduct!!.price)
        val priceText = rootView.findViewById<View>(R.id.priceText) as TextView
        priceText.text = price
        val productId: String = mProduct!!.productId

        val imageResource: Int = activity!!.resources
            .getIdentifier(productId, "drawable", activity?.packageName)
        val iv = rootView.findViewById<View>(R.id.imageView) as ImageView
        iv.setImageResource(imageResource)
        return rootView
    }

    companion object {
        fun newInstance(product: Product?): ItemFragment {
            val args = Bundle()
            args.putParcelable("product key", product)

            val fragment = ItemFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
