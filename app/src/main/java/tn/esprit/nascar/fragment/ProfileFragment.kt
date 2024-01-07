package tn.esprit.nascar.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import tn.esprit.nascar.PREF_FILE
import tn.esprit.nascar.adapters.BookmarksAdapter
import tn.esprit.nascar.databinding.FragmentProfileBinding
import tn.esprit.nascar.utils.AppDatabase

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var userEmail: String // Ajout de la variable pour stocker l'email

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        userEmail = requireContext().getSharedPreferences(PREF_FILE, AppCompatActivity.MODE_PRIVATE)
            .getString("EMAIL", "") ?: ""
        binding.txtEmail.text = userEmail
        //TODO 14 Get all events from database and create the BookmarksAdapter and assign it to the recyclerView rvBookmarks
        binding.rvBookmarks.adapter = BookmarksAdapter(AppDatabase.getInstance(requireContext()).eventDao().getAllEvent())

        binding.rvBookmarks.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvBookmarks.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        return binding.root
    }

}
