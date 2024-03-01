package com.example.mysamplecodes.VideoPlayer

import android.content.Intent
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.net.toUri
import java.util.regex.Pattern


//This is working. But need to work around to making fullscreen.
@Composable
fun YouTubePlayer(
    url: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    /*
    WebView to play YouTube video.
    It will support only "embed" youtube videos like "https://www.youtube.com/embed/4QrYk6DzwJE".
    It wont support "watch?v=" like "https://www.youtube.com/watch?v=NhRp4fCyeas"
    * */
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                settings.javaScriptEnabled = true
                settings.pluginState = WebSettings.PluginState.ON
                webViewClient = WebViewClient()
                webChromeClient = WebChromeClient()
                val video =
                    "<iframe " +
                            "width=\"100%\" " +
                            "height=\"100%\" " +
                            "src=\"$url\" " +
                            "frameborder=\"0\" " +
                            "allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" " +
                            "allowfullscreen>" +
                            "</iframe>"
                loadData(video, "text/html", "utf-8")
            }
        }
    )

}

fun android.content.Context.openYouTube(videoId: String) {
    val intent = android.content.Intent(Intent.ACTION_VIEW, "vnd.youtube:$videoId".toUri())
    intent.putExtra("force_fullscreen", true)
    intent.putExtra("finish_on_ended", true)
    startActivity(intent)
}

//This is to get videoID from Youtube link.
fun extractVideoId(videoUrl: String): String {
    val pattern = Pattern.compile("(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200C\u200B2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*")
    val matcher = pattern.matcher(videoUrl)
    return if (matcher.find()) {
        matcher.group()
    } else {
        throw IllegalArgumentException("Invalid YouTube URL")
    }
}