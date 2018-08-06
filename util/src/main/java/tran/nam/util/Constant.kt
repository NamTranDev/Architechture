package tran.nam.util

import android.util.SparseArray

interface Constant {

    interface REQUEST_CODE {
        companion object {
            val TARGET_FRAGMENT = 123
        }
    }

    interface KEY_INTENT {
        companion object {
            val ID_SEASON = "id season"
        }
    }

    interface KEY_ARGUMENT {
        companion object {
            val LIST_TEAM_DATA = "List Team Data"
            val TEAM_DATA = "Team Data"
        }
    }

    interface KEY_INTENT_RESULT

    interface KEY_DIALOG

    companion object {

        val API_URL = "https://api.football-data.org"
        val EMPTY = ""
    }
}
