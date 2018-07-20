package bedboy.fastandroidnetwork

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = MainActivity::class.simpleName
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidNetworking.initialize(applicationContext)
        AndroidNetworking.get("https://newsapi.org/v2/everything")
                .addQueryParameter("country","us")
                .addQueryParameter("category","business")
                .addQueryParameter("apiKey","252f3d0081664cbaa0f6830293fa634d")
                .setPriority(Priority.IMMEDIATE)
                .build()
                .setAnalyticsListener { timeTakenInMillis, bytesSent, bytesReceived, isFromCache ->
                    Log.e(TAG, timeTakenInMillis.toString())
                    Log.e(TAG, bytesSent.toString())
                    Log.e(TAG, bytesReceived.toString())
                    Log.e(TAG, isFromCache.toString())
                }
                .getAsJSONObject(object : JSONObjectRequestListener{
                    override fun onResponse(response: JSONObject?) {
                        Log.e(TAG, response.toString())
                    }

                    override fun onError(anError: ANError?) {

                    }
                })
    }
}
