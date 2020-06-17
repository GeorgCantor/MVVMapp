package com.example.mvvmapp.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.mvvmapp.R
import com.example.mvvmapp.R.layout.fragment_home
import com.example.mvvmapp.view.home.adapter.HomeAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf

class HomeFragment : Fragment(), Toolbar.OnMenuItemClickListener {

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel { parametersOf() }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(toolbar) {
            title = getString(R.string.app_name)
            navigationIcon = getDrawable(requireContext(), R.drawable.ic_camera)
            setNavigationOnClickListener {
            }

            inflateMenu(R.menu.menu_home)
            setOnMenuItemClickListener(this@HomeFragment)
        }

        viewModel.posts.observe(viewLifecycleOwner, Observer {
            home_recycler.setHasFixedSize(true)
            home_recycler.adapter =
                HomeAdapter(it)
        })
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return true
    }
}