package app.training.android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.training.android.R
import app.training.android.databinding.FragmentNewsHeaderBinding

private const val NEWS_TITLE = "newsTitle"
private const val NEWS_CONTENT = "newsContent"

class NewsHeaderFragment : Fragment() {
    private var newsTitle: String? = null
    private var newsContent: String? = null
    private lateinit var binding: FragmentNewsHeaderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            newsTitle = it.getString(NEWS_TITLE)
            newsContent = it.getString(NEWS_CONTENT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsHeaderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTitle.text = newsTitle
        binding.tvContent.text = newsContent
    }

    companion object {
        @JvmStatic
        fun newInstance(newsTitle: String, newsContent: String) =
            NewsHeaderFragment().apply {
                arguments = Bundle().apply {
                    putString(NEWS_TITLE, newsTitle)
                    putString(NEWS_CONTENT, newsContent)
                }
            }
    }
}