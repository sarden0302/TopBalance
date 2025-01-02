
/****************************************정규식********************************************/
const expIdText = /^[A-Za-z가-힇0-9]{4,20}$/;
const expPwText = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;
const expNameText= /^[가-힣]{2,}/;
const expHpText = /^\d{3}-\d{3,4}-\d{4}$/;
//아이디 정규식 확인 스크립트
const userId = document.getElementById("userId");
const idResult = document.getElementById("id_result");
const userPw = document.getElementById("userPassword");
const userRepw = document.getElementById("userRepeatPassword");
const pwResult1 = document.getElementById("pw_result1");
const pwResult2 = document.getElementById("pw_result2");
const nameResult = document.getElementById("name_result");
const phoneResult = document.getElementById("phone_result");
const userName = document.getElementById("userName");
const userPhone = document.getElementById("userPhone");

// 정규식 확인
function ExpcheckId(event){
    if (!expIdText.test(userId.value)){
        idResult.className = "unabled"
        idResult.innerText = "아이디는 4자~20자 로 제한되어있습니다."
        return;
    }
    idResult.className = "enabled"
    idResult.innerText = "사용가능한 아이디 입니다."
}

function ExpcheckPassword(event){
    if (!expPwText.test(userPw.value)){
        pwResult1.className = "unabled"
        pwResult1.innerText = "비밀번호는 대소문자 특수문자 포함 최소 8자 이상 작성필요합니다."
        return;
    }
    pwResult1.className = "enabled"
    pwResult1.innerText = "사용가능한 비밀번호 입니다."
}

function ExpcheckName(event){
    if (!expNameText.test(userName.value)){
        nameResult.className = "unabled"
        nameResult.innerText = "이름은 최소 2자 이상 필요합니다.."
        return;
    }
    nameResult.className = "enabled"
    nameResult.innerText = ""
}
function ExpcheckPhone(event){
    if (!expHpText.test(userPhone.value)){
        phoneResult.className = "unabled"
        phoneResult.innerText = "핸드폰번호는 - 포함 010-XXXX-XXXX 형식으로 작성 부탁드립니다."
        return;
    }
    phoneResult.className = "enabled"
    phoneResult.innerText = ""
}






function checkingPw(event) {
    if (userPw.value == userRepw.value) {
        pwResult2.className = "enabled";
        pwResult2.innerText = "비밀번호가 일치합니다.";
        return;
    }
    pwResult2.className = "unabled";
    pwResult2.innerText = "비밀번호가 일치하지 않습니다.";
}