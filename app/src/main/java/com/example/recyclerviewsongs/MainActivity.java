package com.example.recyclerviewsongs;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SongAdapter songAdapter;
    private List<Song> songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        songList = new ArrayList<>();
        songList.add(new Song("White Ferrari", "Frank Ocean", R.drawable.ivy,
                "*White Ferrari* adalah sebuah perjalanan melintasi kenangan, sebuah lagu yang membawa pendengarnya ke dalam pelukan masa lalu yang tak lagi bisa digenggam. Dengan melodi yang lembut dan lirik yang penuh makna, Frank Ocean merajut cerita tentang cinta yang pernah bersemi, namun akhirnya harus dilepaskan. Mobil putih yang melaju dalam keheningan menjadi simbol kebebasan, tetapi juga kesunyian yang datang setelah kehilangan. Seperti jalanan yang terbentang tanpa ujung, hubungan itu pernah terasa tak terbatas, hingga akhirnya waktu membisikkan bahwa tak semua yang indah bisa bertahan selamanya. Dalam setiap nada, ada kerinduan yang samar, ada penerimaan yang perlahan, dan ada cinta yang meskipun telah pergi, tetap abadi dalam ingatan.",
                R.raw.song2));
        songList.add(new Song("loose", "Daniel caesar", R.drawable.daniel,
                "*Loose* adalah serenade lembut yang mengalun di antara cinta dan keraguan, menggambarkan ketulusan yang dibayangi ketakutan kehilangan. Daniel Caesar menuangkan perasaan cinta yang dalam namun rapuh, seolah hati berbicara dalam bisikan malam. Melodi yang mengalir lembut dan vokal penuh emosi menciptakan keintiman yang nyata—sebuah cerminan cinta yang indah, namun tak lepas dari ketidakpastian, seperti ombak yang menyentuh pantai hanya untuk kembali ke lautan.",
                R.raw.song3));
        songList.add(new Song("ivy", "Frank ocean", R.drawable.ivy,
                "\"Ivy\" dari Frank Ocean, dalam album *Blonde* (2016), adalah refleksi penuh emosi tentang cinta pertama yang indah namun tak bertahan lama. Dengan lirik, \"I thought that I was dreaming when you said you loved me,\" lagu ini menangkap perasaan nostalgia dan penyesalan saat mengenang hubungan yang dulu terasa seperti mimpi. Melodi lembut, distorsi gitar khas, dan vokal yang mendalam semakin memperkuat kesan manis sekaligus menyakitkan dari kenangan yang telah berlalu.",
                R.raw.song4));
        songList.add(new Song("chanel", "Frank ocean", R.drawable.channel,
                "*\"Chanel\"* oleh Frank Ocean adalah eksplorasi indah tentang dualitas cinta dan identitas. Dengan lirik ikonik *\"My guy pretty like a girl, and he got fight stories to tell,\"* lagu ini menyoroti fluiditas gender dan seksualitas, selaras dengan simbol dua \"C\" saling berlawanan dalam logo Chanel. Melalui vokal penuh emosi dan produksi minimalis, Frank Ocean menciptakan atmosfer introspektif yang merayakan kebebasan dalam mengekspresikan diri dan mencintai tanpa batas.",
                R.raw.song5));
        songList.add(new Song("Rearrange My World", "Daniel caesar x rex orange country", R.drawable.rox,
                "*Rearrange My World* oleh Daniel Caesar adalah lagu penuh emosi tentang cinta dan perubahan. Dengan vokal lembut dan melodi melankolis, ia menggambarkan kerelaan untuk mengubah dirinya demi seseorang yang dicintai. Lirik yang tulus dan produksi intim membuat lagu ini semakin menyentuh dan mendalam.",
                R.raw.song6));
        songList.add(new Song("on the drive home", "Niki", R.drawable.niki,
                "*Loose* adalah serenade lembut yang mengalun di antara cinta dan keraguan, menggambarkan ketulusan yang dibayangi ketakutan kehilangan. Daniel Caesar menuangkan perasaan cinta yang dalam namun rapuh, seolah hati berbicara dalam bisikan malam. Melodi yang mengalir lembut dan vokal penuh emosi menciptakan keintiman yang nyata—sebuah cerminan cinta yang indah, namun tak lepas dari ketidakpastian, seperti ombak yang menyentuh pantai hanya untuk kembali ke lautan.",
                R.raw.song7));
        songList.add(new Song("Rearrange My World", "Daniel caesar x rex orange country", R.drawable.rox,
                "*Loose* adalah serenade lembut yang mengalun di antara cinta dan keraguan, menggambarkan ketulusan yang dibayangi ketakutan kehilangan. Daniel Caesar menuangkan perasaan cinta yang dalam namun rapuh, seolah hati berbicara dalam bisikan malam. Melodi yang mengalir lembut dan vokal penuh emosi menciptakan keintiman yang nyata—sebuah cerminan cinta yang indah, namun tak lepas dari ketidakpastian, seperti ombak yang menyentuh pantai hanya untuk kembali ke lautan.",
                R.raw.song6));




        songAdapter = new SongAdapter(songList);
        recyclerView.setAdapter(songAdapter);
    }
}
