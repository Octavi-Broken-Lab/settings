package nl.joery.animatedbottombar

import android.content.Context
import android.view.MenuInflater
import android.widget.PopupMenu


internal object MenuParser {
    fun parse(context: Context, resId: Int, exception: Boolean): ArrayList<AnimatedBottomBar.Tab> {
        val p = PopupMenu(context, null)
        MenuInflater(context).inflate(resId, p.menu)

        val tabs = ArrayList<AnimatedBottomBar.Tab>()

	val e = p.menu.size()

        for (i in 0 until e) {
            tabs.add(
                AnimatedBottomBar.Tab(
                    title = p.menu.getItem(i).title.toString(),
                    icon = p.menu.getItem(i).icon,
                    id = p.menu.getItem(i).itemId,
                    enabled = p.menu.getItem(i).isEnabled
                )
            )
        }
        return tabs
    }
}
