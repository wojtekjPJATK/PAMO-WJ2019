package com.example.zwiekszmase


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import com.example.zwiekszmase.repository.ResultRepository

class ChartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View =  inflater.inflate(R.layout.fragment_chart, container, false)

        val chartWebView = view.findViewById<WebView>(R.id.chartView)
        val webSettings = chartWebView.settings
        webSettings.javaScriptEnabled = true
        val repo = ResultRepository
        if (repo.all().size == 0) {
            view.findViewById<TextView>(R.id.chartTextView).setText(R.string.diet_error)
            return view
        }
        val results = repo.chartData()

        val html = ("<html>"
                + "  <head>"
                + "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>"
                + "    <script type=\"text/javascript\">"
                + "      google.charts.load('current', {'packages':['corechart']});"
                + "      google.charts.setOnLoadCallback(drawChart);"
                + "      function drawChart() {"
                + "        var data = google.visualization.arrayToDataTable(["
                + "          ['Kg', 'Masa']," + results + "]);"
                + "        var options = {\n"
                + "          title: 'Zmiana wagi w czasie',\n"
                + "          curveType: 'function',\n"
                + "          legend: { position: 'bottom' }\n"
                + "        };\n"
                + "        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));"
                + "        chart.draw(data, options);"
                + "      }"
                + "    </script>"
                + "  </head>"
                + "  <body>"
                + "    <div id=\"curve_chart\" style=\"width: 375px; height: 480px;\"></div>"
                + "  </body>"
                + "</html>")

        chartWebView.loadData(html, "text/html", "UTF-8")

        return view
    }


}
