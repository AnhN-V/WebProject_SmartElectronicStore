<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <script>
        function toast({
                           status = 1
                       }) {
            const app = document.querySelector('.wrap');
            const wrap = document.createElement('div');
            if(status == 1) {
                wrap.innerHTML = `
            <div class="alert alert-unsignin">
            <i class="check-icon fas fa-check-circle icon-unsignin"></i>
            <div class="content">
                <h3 class="content-head">Lỗi!</h3>
                <p class="content-sub">Tài khoản của bạn không tồn tại</p>
            </div>
            <div class = "icon">
            <i class="close-icon fas fa-times"></i></div>
        </div>
            `;
            } else if(status == 2) {
                wrap.innerHTML = `
            <div class="alert alert-unsignin">
            <i class="check-icon fas fa-check-circle icon-unsignin"></i>
            <div class="content">
                <h3 class="content-head">Lỗi!</h3>
                <p class="content-sub">Mật khẩu bạn nhập không chính xác.</p>
            </div>
            <div class = "icon">
            <i class="close-icon fas fa-times"></i></div>
        </div>
            `;
            } else if(status == 3) {
                wrap.innerHTML = `
            <div class="alert alert-signin">
            <i class="check-icon fas fa-check-circle icon-signin"></i>
            <div class="content">
                <h3 class="content-head">Thành công!</h3>
                <p class="content-sub">Bạn đã đăng kí thành công.</p>
            </div>
            <div class = "icon">
            <i class="close-icon fas fa-times"></i></div>
        </div>
            `;
            } else if(status == 4) {
                wrap.innerHTML = `
            <div class="alert alert-unsignin">
            <i class="check-icon fas fa-check-circle icon-unsignin"></i>
            <div class="content">
                <h3 class="content-head">Lỗi!</h3>
                <p class="content-sub">Email đăng kí này đã được liên kết với một tài khoản khác.</p>
            </div>
            <div class = "icon">
            <i class="close-icon fas fa-times"></i></div>
        </div>
            `;
            } else if(status == 5) {
                wrap.innerHTML = `
            <div class="alert alert-unsignin">
            <i class="check-icon fas fa-check-circle icon-unsignin"></i>
            <div class="content">
                <h3 class="content-head">Lỗi!</h3>
                <p class="content-sub">Mật khẩu nhập lại không đúng.</p>
            </div>
            <div class = "icon">
            <i class="close-icon fas fa-times"></i></div>
        </div>
            `;
            } else if(status == 6) {
                wrap.innerHTML = `
            <div class="alert alert-unsignin">
            <i class="check-icon fas fa-check-circle icon-unsignin"></i>
            <div class="content">
                <h3 class="content-head">Lỗi!</h3>
                <p class="content-sub">Email này không tồn tại.</p>
            </div>
            <div class = "icon">
            <i class="close-icon fas fa-times"></i></div>
        </div>
            `;
            } else if(status == 7) {
                wrap.innerHTML = `
            <div class="alert alert-signin">
            <i class="check-icon fas fa-check-circle icon-signin"></i>
            <div class="content">
                <h3 class="content-head">Thành công!</h3>
                <p class="content-sub">Kiểm tra mail để reset password.</p>
            </div>
            <div class = "icon">
            <i class="close-icon fas fa-times"></i></div>
        </div>
            `;
            }

            app.appendChild(wrap);
            //Tắt auto
            const autoclose = setTimeout(function() {
                app.removeChild(wrap);
            }, 3000)
            //Tắt bằng cách click
            wrap.onclick = function(e) {
                console.log(e.target);

                if (e.target.closest('.icon')) {
                    app.removeChild(wrap);
                    clearTimeout(autoclose);
                }
            }
        }

        function showalertdk() {
            toast({
                status: 1
            });
        }

        function showalerthdk() {
            toast({
                status: 2
            });
        }

        function showalertdkSuccess() {
            toast({
                status: 3
            });
        }

        function showalertdkFail() {
            toast({
                status: 4
            });
        }

        function showalertRePassword() {
            toast({
                status: 5
            });
        }

        function showalertNotFoundEmail() {
            toast({
                status: 6
            });
        }

        function showalertResetPassword() {
            toast({
                status: 7
            });
        }


    //    Fetch API
        document.querySelector(".register_button").onclick = (e) => {
            const email = document.getElementById("email").value
            const password = document.getElementById("pass").value
            const first_name = document.getElementById("first_name").value
            const last_name = document.getElementById("last_name").value
            const re_password = document.getElementById("re-password").value
            const checkUniqueEmail = fetch('/checkUniqueEmail?email='+email)
                .then((response) => response.json())
                .then(e => e);
            const getEmail = async () => {
                const isExistEmail = await checkUniqueEmail;
                if(isExistEmail) {
                    window.scrollTo({ top: 0, behavior: 'smooth' });
                    showalertdkFail()
                } else if(password != re_password) {
                    window.scrollTo({ top: 0, behavior: 'smooth' });
                    showalertRePassword()
                    e.preventDefault()
                    return;
                } else {
                    const signUp = fetch('/sign-up?email='+ email+
                        '&password='+ password+
                        '&first_name='+ first_name+
                        '&last_name='+last_name
                    )
                        .then((response) => response.json())
                        .then(e => e);
                    document.getElementById("email").value = ""
                    document.getElementById("pass").value = ""
                    document.getElementById("first_name").value = ""
                    document.getElementById("last_name").value = ""
                    document.getElementById("re-password").value = ""
                    window.scrollTo({ top: 0, behavior: 'smooth' });
                    showalertdkSuccess()
                }
            };
            getEmail()
            e.preventDefault()
        };
    </script>

