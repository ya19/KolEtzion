package edu.etzion.koletzion.database;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class BitmapSerializer {
	public static Bitmap decodeStringToBitmap(String encodedBitmap){
		byte[] decodedBytes = Base64.decode(encodedBitmap, 0);
		return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
	}
	
	public static String encodeBitmapToString(Bitmap bitmap){
		ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOS);
		return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);
	}
	
	public static Bitmap getBitmapFromImageView(ImageView imageView){
		return ((BitmapDrawable)imageView.getDrawable()).getBitmap();
	}
}
