
/****************************************정규식********************************************/
//아이디 정규식 확인 스크립트
document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("checkRegExp");
    const Id = document.getElementById("userId").value;
    const IdRegex = /^[A-Za-z가-힇]{4,20}$/;

    form.addEventListener("submit", (event) => {
        if (!IdRegex.test(Id)) {
            alert("유효한 아이디를 입력해주세요.");
            Id.focus();
            event.preventDefault();
            return false;    //
        }
        return true;     //
    });
});