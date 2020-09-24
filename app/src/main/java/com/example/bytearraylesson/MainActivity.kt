package com.example.bytearraylesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

val TAG = "myTag"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         val tcpWifiCommand = TcpWifiCommand()
        length(tcpWifiCommand)
        tcpWifiCommand.tcpWifiSend()
        tcpWifiCommand.tcpWifiReceiver()
    }

    fun length(tcpWifiCommand: TcpWifiCommand) {
        tcpWifiCommand.ssid_2_4GLength = editTextSsid_2_4G.text.toString().length
        tcpWifiCommand.password_2_4GLength = editTextPassword_2_4G.text.toString().length
        tcpWifiCommand.ssid_5GLength = editTextSsid_5G.text.toString().length
        tcpWifiCommand.password_5GLength = editTextPassword_5G.text.toString().length
        tcpWifiCommand.eapUserIdLength = editTextEapUserId.text.toString().length
        tcpWifiCommand.eapUserPasswordLength = editTextEapPassword.text.toString().length

//        Log.d(TAG, "tcpWifiCommand.ssid_2_4GLength:${tcpWifiCommand.ssid_2_4GLength} ")
 //       Log.d(TAG, "tcpWifiCommand.password_2_4GLength:${tcpWifiCommand.password_2_4GLength} ")
  //      Log.d(TAG, "tcpWifiCommand.ssid_5GLength:${tcpWifiCommand.ssid_5GLength} ")

   //     Log.d(TAG, " tcpWifiCommand.password_5GLength:${tcpWifiCommand.password_5GLength} ")
   //     Log.d(TAG, "tcpWifiCommand.eapUserIdLength:${tcpWifiCommand.eapUserIdLength} ")
   //     Log.d(TAG, "tcpWifiCommand.eapUserPasswordLength:${tcpWifiCommand.eapUserPasswordLength} ")

        //資料段的長度 111
        tcpWifiCommand.operationLength =
            1 +  //tcpWifiCommand.sendType
                    3 +  //wifi version
                    6 +  //mac address
                    1 +    //BandSwitch
                    1 +   // ssid_2.4g length
                    tcpWifiCommand.ssid_2_4GLength +
                    1 +    //password_2.4g length
                    tcpWifiCommand.password_2_4GLength +
                    1 +   //bandswitch 5g
                    1 +   //ssid_5g length
                    tcpWifiCommand.ssid_5GLength +
                    1 +   //password_5g length
                    tcpWifiCommand.password_5GLength +
                    1 +    //eap method
                    1 +     //eap innerMethod
                    1 +     // eap user id length
                    tcpWifiCommand.eapUserIdLength +
                    1 +     //eap password length
                    tcpWifiCommand.eapUserPasswordLength +
                    4 +      //SGIP
                    7      // Serial Number

        Log.d(TAG, "operationLength: ${tcpWifiCommand.operationLength} ")
         tcpWifiCommand.protocolLength =tcpWifiCommand.operationLength+2
        Log.d(TAG, "protocolLength: ${tcpWifiCommand.protocolLength}")

        //cs 是算出來的
        //      tcpWifiCommand.cs = 0
        //       for (i in 1..2) {
        //           tcpWifiCommand.cs = tcpWifiCommand.cs + tcpWifiCommand.dataIntArray[i]
        //       }


    }



}