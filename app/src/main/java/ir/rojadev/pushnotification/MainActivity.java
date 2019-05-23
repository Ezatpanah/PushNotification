package ir.rojadev.pushnotification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    Button btnsimple;
    Button btn_penint;
    Button btn_ncolor;
    Button btn_largicon;
    Button btn_hedupnoti;
    Button btn_actionnotif;
    Button btn_btnbigtext;
    Button btn_bigpictuer;
    Button btn_expandable;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fndViwid();

        //1-Simple Notification/////////////////////////////////////////////////////////////////
        btnsimple.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                simple();
            }
        });

        //2-Pending Intent Notification//////////////////////////////////////////////////////////
        btn_penint.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                penint();
            }
        });

        //3-Notification With Color//////////////////////////////////////////////////////////////
        btn_ncolor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                color();
            }
        });

        //4-Notification With Larg Icon/////////////////////////////////////////////////////////
        btn_largicon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                largicon();
            }
        });

        //5- Heads-Up Notification///////////////////////////////////////////////////////////////
        btn_hedupnoti.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                hedupnoti();

            }
        });

        //6-Notification With Action///////////////////////////////////////////////////////////////
        btn_actionnotif.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                actionnotif();

            }
        });

        //7-Big Text Notification///////////////////////////////////////////////////////////////
        btn_btnbigtext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bigtext();

            }
        });

        //8-BigPictuer Style Notification///////////////////////////////////////////////////////
        btn_bigpictuer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bigpictuer();

            }
        });

        //9- Expandable Notification///////////////////////////////////////////////////////
        btn_expandable.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                expandable();

            }
        });

    }

    public void fndViwid()
    {
        btnsimple = findViewById(R.id.btm_simno);
        btn_penint = findViewById(R.id.btn_penint);
        btn_ncolor = findViewById(R.id.btn_ncolor);
        btn_largicon = findViewById(R.id.btn_largicon);
        btn_hedupnoti = findViewById(R.id.btn_hedupnoti);
        btn_actionnotif = findViewById(R.id.btn_actionnotif);
        btn_btnbigtext = findViewById(R.id.btn_btnbigtext);
        btn_bigpictuer = findViewById(R.id.btn_bigpictuer);
        btn_expandable = findViewById(R.id.btn_expandable);
    }

    public void simple()
    {
        int notificID = 1;

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = null;


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel("ID", "Name"
                    , importance);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new NotificationCompat.Builder(
                    getApplicationContext(),
                    notificationChannel.getId()
            );
        }
        else
        {

            builder = new NotificationCompat.Builder(getApplicationContext());
        }

        //UI For Notification
        builder = builder
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Simple Notification")
                .setContentText("This is Simple Notification")
                .setAutoCancel(true)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        //**


        notificationManager.notify(notificID, builder.build());
    }

    public void penint()
    {
        int notificID = 2;

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = null;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel("ID", "Name"
                    , importance);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new NotificationCompat.Builder(
                    getApplicationContext(),
                    notificationChannel.getId()
            );
        }
        else
        {

            builder = new NotificationCompat.Builder(getApplicationContext());
        }

        //UI For Notification
        builder = builder
                .setSmallIcon(R.drawable.ic_sms_failed_black_24dp)
                .setContentTitle("Pending Notification")
                .setContentText("Click this and See Setting and Enable")
                .setAutoCancel(true)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));

        //**

        Intent openact = new Intent(MainActivity.this, SecondActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);
        stackBuilder.addParentStack(SecondActivity.class);
        stackBuilder.addNextIntent(openact);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(
                0,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        builder.setContentIntent(pendingIntent);
        notificationManager.notify(notificID, builder.build());

    }

    public void color()
    {
        int notificID = 3;

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel("ID", "Name"
                    , importance);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new NotificationCompat.Builder(
                    getApplicationContext(),
                    notificationChannel.getId()
            );
        }
        else
        {
            builder = new NotificationCompat.Builder(getApplicationContext());
        }

        //UI For Notification
        builder = builder
                .setSmallIcon(R.drawable.ic_assignment_black_24dp)
                .setContentTitle("Android Notification Color")
                .setContentText("This is  Notification With Color")
                .setColor(Color.parseColor("#3F51B5"))
                .setAutoCancel(true)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        //**

        notificationManager.notify(notificID, builder.build());
    }

    public void largicon()
    {
        int notificID = 4;

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = null;


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel("ID", "Name"
                    , importance);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new NotificationCompat.Builder(
                    getApplicationContext(),
                    notificationChannel.getId()
            );
        }
        else
        {

            builder = new NotificationCompat.Builder(getApplicationContext());
        }


        //UI For Notification
        builder = builder
                .setSmallIcon(R.drawable.ic_beenhere_black_24dp)
                .setContentTitle("Larg Icon Notification")
                .setContentText("This is Notification With Larg Icon")
                .setColor(Color.parseColor("#00574B"))
                .setLargeIcon(BitmapFactory.decodeResource(
                        getResources(),
                        R.drawable.logosmall
                ))
                .setAutoCancel(true)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));

        //**

        notificationManager.notify(notificID, builder.build());
    }

    public void hedupnoti()
    {
        int notificID = 5;

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = null;


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel("ID", "Name"
                    , importance);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new NotificationCompat.Builder(
                    getApplicationContext(),
                    notificationChannel.getId()
            );
        }
        else
        {

            builder = new NotificationCompat.Builder(getApplicationContext());
        }


        //UI For Notification
        builder = builder
                .setSmallIcon(R.drawable.ic_beenhere_black_24dp)
                .setContentTitle("A New Message!")
                .setContentText("Hi, how are you? Please see each other soon")
                .setColor(Color.parseColor("#03A9F4"))
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.user))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);
        //**

        notificationManager.notify(notificID, builder.build());
    }

    public void actionnotif()
    {
        int notificID = 6;

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = null;


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel("ID", "Name"
                    , importance);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new NotificationCompat.Builder(
                    getApplicationContext(),
                    notificationChannel.getId()
            );
        }
        else
        {

            builder = new NotificationCompat.Builder(getApplicationContext());
        }


        Intent OPEN_AVTIVITY = new Intent(MainActivity.this, SecondActivity.class);
        PendingIntent reply = PendingIntent.getActivity(MainActivity.this, 0,
                OPEN_AVTIVITY, PendingIntent.FLAG_UPDATE_CURRENT
        );


        //UI For Notification
        builder = builder
                .setSmallIcon(R.drawable.ic_assignment_black_24dp)
                .setContentTitle("Emad Keyvani")
                .setContentText("Hi! please Email the files. I'm waiting...")
                .setColor(Color.parseColor("#03A9F4"))
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.user))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .addAction(R.drawable.ic_close_black_24dp, "Dismiss", null)
                .addAction(R.drawable.ic_reply_black_24dp, "Reply", reply)
                .setAutoCancel(true);
        //**


        notificationManager.notify(notificID, builder.build());
    }

    public void bigtext()
    {
        int notificID = 7;

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = null;


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel("ID", "Name"
                    , importance);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new NotificationCompat.Builder(
                    getApplicationContext(),
                    notificationChannel.getId()
            );
        }
        else
        {

            builder = new NotificationCompat.Builder(getApplicationContext());
        }

        //UI For Notification
        builder = builder
                .setSmallIcon(R.drawable.ic_assignment_black_24dp)
                .setContentTitle("Emad Keyvani")
                .setContentText("Hi! please Email the files. I'm waiting...")
                .setColor(Color.parseColor("#03A9F4"))
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.user))
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setAutoCancel(true);
        //**

        NotificationCompat.BigTextStyle bts = new NotificationCompat.BigTextStyle()
                .bigText("Hello! Email the files to me. I'm waiting to send them. When " +
                        "you send files please contact me to read the files and prepare " +
                        "for tomorrow.");
        builder.setStyle(bts);

        notificationManager.notify(notificID, builder.build());
    }

    public void bigpictuer()
    {
        int notificID = 8;

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = null;


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel("ID", "Name"
                    , importance);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new NotificationCompat.Builder(
                    getApplicationContext(),
                    notificationChannel.getId()
            );
        }
        else
        {

            builder = new NotificationCompat.Builder(getApplicationContext());
        }

        //UI For Notification
        builder = builder
                .setSmallIcon(R.drawable.ic_image_black_24dp)
                .setContentTitle("Picture Recived")
                .setContentText("Touch To view This Picture")
                .setAutoCancel(true)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        //**

        NotificationCompat.BigPictureStyle bps = new NotificationCompat.BigPictureStyle()
                .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.logo))
                .setSummaryText("This Is a BigPicture Notification");
        builder.setStyle(bps);

        notificationManager.notify(notificID, builder.build());
    }

    public void expandable()
    {
        int notificID = 9;

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = null;


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel("ID", "Name"
                    , importance);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new NotificationCompat.Builder(
                    getApplicationContext(),
                    notificationChannel.getId()
            );
        }
        else
        {

            builder = new NotificationCompat.Builder(getApplicationContext());
        }

        //UI For Notification
        builder = builder
                .setSmallIcon(R.drawable.ic_line_weight_black_24dp)
                .setContentTitle("Notification of lesson changes")
                .setContentText("Lessons that have been added.")
                .setColor(Color.parseColor("#0000ff"))
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        //**

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

        inboxStyle.setBigContentTitle("The list of lessons are:");

        String[] courses = new String[5];
        courses[0] = "Information processing";
        courses[1] = "System programming";
        courses[2] = "Object-oriented systems";
        courses[3] = "Databases";
        courses[4] = "Special Topics";

        for (int i = 0; i < courses.length; i++)
        {
            inboxStyle.addLine(courses[i]);
        }

        builder.setStyle(inboxStyle);

        notificationManager.notify(notificID, builder.build());
    }


}
