package info.android.viewpager2app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

data class Movie(val time: String, val group: String, val auditory: Int, val name: String, val subject: String)

class MainFragment : Fragment() {

    private val nicCageMovies = listOf(
        Movie("08.45-10.15","ЩИКО-02-20", 260, "МЮРА ЮИЛИЦИН", "ШИЗИКА"),
        Movie("10.30-12.00","ЩИКО-01-20", 260, "МЮРА ЮИЛИЦИН", "ШИЗИКА"),
        Movie("12.40-14.10","ЩИКО-04-21", 260, "РАКСИМ МАМАШИН", "ФИЗ-РА"),
        Movie("14.20-15.50","ЩАКО-01-20", 260, "МЮРА ЮИЛИЦИН", "ШИЗИКА"),
        Movie("пиздец поздно","Хуегруппа", 1988, "все", "собрание у нас дура")
        /*Movie("Con Air", 1997, "con_air.jpg", "ШИЗИКА"),
        Movie("Face/Off", 1997, "face_off.jpg", "ШИЗИКА"),
        Movie("National Treasure", 2004, "national_treasure.jpg", "ШИЗИКА"),
        Movie("The Wicker Man", 2006, "wicker_man.jpg", "ШИЗИКА"),
        Movie("Bad Lieutenant", 2009, "bad_lieutenant.jpg", "ШИЗИКА"),
        Movie("Kick-Ass", 2010, "111", "ШИЗИКА")*/
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_main, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListAdapter(nicCageMovies)
        }
    }

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }
}