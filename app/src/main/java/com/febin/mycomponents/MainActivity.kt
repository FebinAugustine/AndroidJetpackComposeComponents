package com.febin.mycomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.febin.mycomponents.menuComponents.ExposedDropdownMenuBoxComp
import com.febin.mycomponents.menuComponents.ExposedDropdownMenuBoxCompEditable
import com.febin.mycomponents.ui.theme.MyComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyComponentsTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { values ->
//                    CommonButtons(
//                        onClick = { /*TODO*/ },
//                        modifier = Modifier
//                            .padding(values),
//
//                        )
                    ExposedDropdownMenuBoxCompEditable(
                        modifier = Modifier
                            .padding(values)
                    )
                }


            }
        }
    }
}

