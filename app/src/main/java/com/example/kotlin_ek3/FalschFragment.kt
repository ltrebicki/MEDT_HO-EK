package com.example.kotlin_ek3

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.findNavController
import com.example.kotlin_ek3.databinding.FragmentFalschBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SchlechtFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SchlechtFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SchlechtFragment : Fragment() {
    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelName"
    val NOTIFICAITON_ID = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Ergebnis"
        val binding = DataBindingUtil.inflate<FragmentFalschBinding>(inflater,
            R.layout.fragment_falsch,container,false)
        binding.buttonNeuerVersuch.setOnClickListener{view: View->
            view.findNavController()
                .navigate(R.id.action_falschFragment_to_mainFragment)}

        val pendingIntent = NavDeepLinkBuilder(context!!)
            .setGraph(R.navigation.navigation)
            .setDestination(R.id.mainFragment)
            .createPendingIntent()

        createNotificationChannel()
        val notification = NotificationCompat.Builder(context!!, CHANNEL_ID)
            .setContentTitle("Leider falsch!")
            .setContentText("Hier kannst du es nochmal versuchen!")
            .setSmallIcon(R.drawable.ic_star_border_24px)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)    // um zu canceln wenn User anklickt
            .build()


        val notificationManager = NotificationManagerCompat.from(context!!)
        notificationManager.notify(NOTIFICAITON_ID, notification)

        return binding.root
    }

    fun createNotificationChannel() {
        // Oreo oder neuer?
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor = Color.RED
                enableLights(true)
            }
            val manager = this.activity?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}