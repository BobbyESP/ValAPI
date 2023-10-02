package com.bobbyesp.valapi

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.bobbyesp.valapi.library.domain.model.agent.Agent
import com.bobbyesp.valapi.library.domain.respository.ValorantAPI
import com.bobbyesp.valapi.library.domain.respository.agents.AgentsAPI
import com.bobbyesp.valapi.library.util.LanguageCode
import com.bobbyesp.valapi.library.util.data.Resource
import com.bobbyesp.valapi.ui.theme.ValAPITheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValAPITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val scope = rememberCoroutineScope()
                    val agents = viewModel.agents.collectAsStateWithLifecycle()
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(
                            8.dp,
                            Alignment.CenterVertically
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(onClick = { viewModel.getAgents() }) {
                            Text(text = "Get Agents")
                        }

                        Text(text = agents.value.toString())
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ValAPITheme {
        Greeting("Android")
    }
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val agentsAPI: AgentsAPI,
    private val valorantAPI: ValorantAPI
): ViewModel() {

    private val _agents: MutableStateFlow<List<Agent>> = MutableStateFlow(listOf(Agent()))
    val agents = _agents
    fun getAgents() {
        viewModelScope.launch(Dispatchers.IO) {
            agentsAPI.getAgents(LanguageCode.SPANISH_SPAIN).collectLatest { resource ->
                when(resource) {
                    is Resource.Success -> {
                        _agents.update {
                            resource.data ?: emptyList()
                        }
                    }
                    is Resource.Error -> {
                        Log.i("MainViewModel", "Error: ${resource.message}")
                        _agents.update {
                            emptyList()
                        }
                    }
                    is Resource.Loading -> {
                        _agents.update {
                            emptyList()
                        }
                    }
                }
            }
        }
    }
}

@HiltAndroidApp
class App: Application() {
}