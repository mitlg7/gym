<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    <form class="container" method="post">
        <div class="row g-3">
            <div class="col">
                <label for="name" class="form-label">Имя</label>
                <input name="name" id="name" type="text" required minlength="3" maxlength="24" class="form-control" placeholder="Имя" aria-label="Имя">
            </div>
            <div class="col">
                <label for="lastname" class="form-label">Фамилия</label>
                <input name="lastname" id="lastname"  required minlength="3" maxlength="24" type="text" class="form-control" placeholder="Фамилия"
                       aria-label="Фамилия">
            </div>
        </div>
        <div class="row g-3">
            <div class="col">
                <label for="phone" class="form-label">Телефон</label>
                <input name="phone" id="phone" type="tel" required class="form-control" placeholder="Телефон">
            </div>
            <div class="col">
                <label for="birthday" class="form-label">Дата рождения</label>
                <input name="birthday" id="birthday" required min="1910-01-01" max="2021-01-01" type="date" class="form-control" placeholder="Дата рождения">
            </div>
        </div>
        <div class="row g-3">
            <div class="col">
                <label for="email" class="form-label">Почта</label>
                <input name="email" id="email" type="email" required class="form-control" placeholder="email">
            </div>

        </div>
        <div class="col">
            <label for="gender" class="form-label">Пол</label>
            <select class="form-control" name="gender" id="gender">
                <#list  genders as gender>
                    <option value="${gender.id}">${gender.type}</option>
                </#list>
            </select>
        </div>
        <div class="row">
            <button type="submit" class="mx-auto col-8 btn btn-secondary mt-5 ">Сохранить</button>
        </div>
    </form>


</@component.skeleton>