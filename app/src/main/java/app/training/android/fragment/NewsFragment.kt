package app.training.android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import app.training.android.R
import app.training.android.adapter.NewsAdapter
import app.training.android.databinding.FragmentNewsBinding
import app.training.android.model.NewsModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class NewsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentNewsBinding
    private var newsList = ArrayList<NewsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvNews.layoutManager = LinearLayoutManager(requireContext())
        initData()
        val adapter = NewsAdapter(newsList)
        binding.rvNews.adapter = adapter
    }

    private fun initData(){
        val dummyNews = listOf(
            NewsModel(
                title = "Peluncuran Aplikasi Baru",
                content = "Startup lokal resmi meluncurkan aplikasi keuangan digital untuk UMKM.",
                totalView = "1.2K"
            ),
            NewsModel(
                title = "Update Android Terbaru",
                content = "Google merilis pembaruan Android dengan peningkatan keamanan dan performa.",
                totalView = "3.5K"
            ),
            NewsModel(
                title = "Harga BBM Naik",
                content = "Pemerintah mengumumkan penyesuaian harga BBM mulai bulan depan.",
                totalView = "8.9K"
            ),
            NewsModel(
                title = "Tips Kerja Remote",
                content = "Beberapa tips efektif agar tetap produktif saat bekerja dari rumah.",
                totalView = "950"
            ),
            NewsModel(
                title = "Event Teknologi 2025",
                content = "Konferensi teknologi terbesar di Asia akan digelar secara hybrid.",
                totalView = "4.1K"
            ),
            NewsModel(
                title = "Keamanan Data Pengguna",
                content = "Pakar mengingatkan pentingnya enkripsi data untuk aplikasi mobile.",
                totalView = "2.7K"
            ),
            NewsModel(
                title = "Startup AI Berkembang Pesat",
                content = "Investasi di sektor kecerdasan buatan meningkat signifikan tahun ini.",
                totalView = "6.3K"
            ),
            NewsModel(
                title = "Game Lokal Mendunia",
                content = "Game buatan developer Indonesia berhasil menembus pasar global.",
                totalView = "5.8K"
            ),
            NewsModel(
                title = "Cloud Computing Tren Baru",
                content = "Perusahaan mulai beralih ke solusi cloud untuk efisiensi biaya.",
                totalView = "3.9K"
            ),
            NewsModel(
                title = "Tips Keamanan Akun",
                content = "Gunakan autentikasi dua faktor untuk melindungi akun digital Anda.",
                totalView = "1.6K"
            )
        )
        newsList.addAll(dummyNews)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}