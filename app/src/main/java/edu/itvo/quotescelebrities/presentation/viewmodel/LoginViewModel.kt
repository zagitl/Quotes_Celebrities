package edu.itvo.quotescelebrities.presentation.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.itvo.quotescelebrities.data.model.LoginRequest
import edu.itvo.quotescelebrities.data.remote.UserLoginResponse
import edu.itvo.quotescelebrities.domain.usecase.LoginUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class LoginViewModel
@Inject constructor (private val loginUserUseCase: LoginUserUseCase
): ViewModel(){

    private var _user = MutableStateFlow(
        UserLoginResponse(false,"","")
    )
    val user : StateFlow<UserLoginResponse>? = _user

    fun login (loginRequest: LoginRequest){
        viewModelScope.launch {
            val loginResponse = loginUserUseCase.login(loginRequest)?.first()
            loginResponse.let{
                if (!(it!!.success)) {
                    it!!.data = it!!.data + Random.nextInt(1, 99999)
                }
                _user.value = it

            }
        }
    }

}