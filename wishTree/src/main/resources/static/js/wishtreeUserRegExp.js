
/****************************************정규식********************************************/
//정규식들
const expIdText = /^[A-Za-z가-힇0-9]{4,20}$/;
const expPwText = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;
const expNameText= /^[가-힣]{2,}/;
const expHpText = /^\d{3}-\d{3,4}-\d{4}$/;
//유저값
const userId = document.getElementById("userId");
const userPw = document.getElementById("userPassword");
var userRepw = document.getElementById("userRepeatPassword");
const userName = document.getElementById("userName");
const userPhone = document.getElementById("userPhone");
//알림값
const idResult = document.getElementById("id_result");
const idCheckResult = document.getElementById("idCheck_result");
const pwResult1 = document.getElementById("pw_result1");
const pwResult2 = document.getElementById("pw_result2");
const nameResult = document.getElementById("name_result");
const phoneResult = document.getElementById("phone_result");

const registerButton = document.getElementById("register-button");
//폼 제출 체크포인트


var idValidation = false;
var pwValidation = false;
var pwDuplicateValidation = false;;
var nameValidation = false;
var phoneValidation = false;

let validationMsg = document.getElementById("validation_result");
registerButton.disabled = true;
let buttonResult = false;
let registerForm = document.getElementById("registerForm");

//아이디 중복 확인 및 정규식 체크

    $(document).ready(function () {
    $('#userId').blur(function () {
        const userId = $('#userId').val();
        if (!userId) {
            alert('아이디는 공백이 될 수 없습니다.');
            return;
        }
        $.ajax({
            url: '/check-userId',
            type: 'POST',
            data: {userId: userId},
            success: function (response) {
                if (response.userExists) {
                    registerButton.disabled = true;
                    $('#idCheck_result').text('이미 사용중인 유저이름입니다.').css('color', 'red');
                    $("#userId").val('');
                } else {
                    $('#idCheck_result').text('사용가능한 유저이름입니다.').css('color', 'green');
                    buttonResult = true;

                    if(idValidation && pwValidation && pwDuplicateValidation && nameValidation && phoneValidation && buttonResult) {
                        registerButton.disabled = false;
                    }

                }
            },
            error: function () {
                alert('서버 요청 중 오류가 발생했습니다. 유저네임 중복확인 불가합니다.');
            }
        })
    });
});




// 정규식 확인

function ExpcheckId(event){
    if (!expIdText.test(userId.value)){
        idResult.style.display = 'block';
        idResult.className = "unabled"
        idResult.innerText = "아이디는 4자~20자 로 제한되어있습니다."
        idCheckResult.style.display = 'none';
        registerButton.disabled = true;
        return;
    }
    idResult.style.display = 'none';
    idCheckResult.style.display = 'block';
    idValidation = true;

    if(idValidation && pwValidation && pwDuplicateValidation && nameValidation && phoneValidation && buttonResult) {
        registerButton.disabled = false;
    }
}

function ExpcheckPassword(event){
    if (!expPwText.test(userPw.value)){
        pwResult1.className = "unabled"
        pwResult1.innerText = "비밀번호는 대소문자 특수문자 포함 최소 8자 이상 작성필요합니다."
        registerButton.disabled = true;
        return;
    }
    console.log(idValidation && pwValidation && pwDuplicateValidation && nameValidation && phoneValidation && buttonResult);
    pwResult1.className = "enabled"
    pwResult1.innerText = "사용가능한 비밀번호 입니다."
    pwValidation =true;

    if(idValidation && pwValidation && pwDuplicateValidation && nameValidation && phoneValidation && buttonResult) {
        registerButton.disabled = false;
    }
}

function ExpcheckName(event){
    if (!expNameText.test(userName.value)){
        nameResult.className = "unabled"
        nameResult.innerText = "이름은 한글로 최소 2자 이상 필요합니다."
        registerButton.disabled = true;
        return;

    }
    nameResult.className = "enabled"
    nameResult.innerText = ""
    nameValidation =true;

    if(idValidation && pwValidation && pwDuplicateValidation && nameValidation && phoneValidation && buttonResult) {
        registerButton.disabled = false;
    }
}

function ExpcheckPhone(event){
    if (!expHpText.test(userPhone.value)){
        phoneResult.className = "unabled"
        phoneResult.innerText = "핸드폰번호는 - 포함 010-XXXX-XXXX 입니다."
        registerButton.disabled = true;
    }
    console.log(idValidation && pwValidation && pwDuplicateValidation && nameValidation && phoneValidation && buttonResult);
    phoneResult.className = "enabled"
    phoneResult.innerText = ""
    phoneValidation = true;

    if(idValidation && pwValidation && pwDuplicateValidation && nameValidation && phoneValidation && buttonResult) {
        registerButton.disabled = false;
    }
}

// 비밀번호 더블체크
function checkingPw(event) {
    if (userPw.value == userRepw.value) {
        pwResult2.className = "enabled";
        pwResult2.innerText = "비밀번호가 일치합니다.";
        pwDuplicateValidation = true;

        if(idValidation && pwValidation && pwDuplicateValidation && nameValidation && phoneValidation && buttonResult) {
            registerButton.disabled = false;
        }
        return;
    }
    pwResult2.className = "unabled";
    pwResult2.innerText = "비밀번호가 일치하지 않습니다.";
    registerButton.disabled = true;
}

// 비밀번호 새로 작성시 비밀번호 확인 초기화
function resetRepeatPassword(){
    userRepw.value = null;
}



function acceptSubmit(){
    if( idValidation
        &&pwValidation
        &&nameValidation
        &&phoneValidation ){
        registerForm.submit()
        return;
    }
    validationMsg.className='unabled'
    validationMsg.innerText= "서식이 달라 제출에 어려움이 있습니다."
}

