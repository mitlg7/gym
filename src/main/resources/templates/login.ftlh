<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    <div class="container mt-5 mb-3">
        <div class="row d-flex justify-content-center">
            <div class="col-md-10">
                <div class="card">
                    <form class="container col-6 mt-4" method="post" action="login">
                        <div class="form-group">
                            <label for="username">Логин: </label>
                            <input name="username" minlength="5" maxlength="20" type="text" class="form-control"
                                   id="username" placeholder="Логин">
                        </div>
                        <div class="form-group">
                            <label for="password">Пароль: </label>
                            <input name="password" minlength="5" maxlength="20" type="password" class="form-control"
                                   id="password" placeholder="Пароль">
                        </div>
                        <div class="row">
                            <button type="submit" class="mx-auto col-8 btn btn-warning btn-lg mt-5 ">Войти</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</@component.skeleton>