<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    <form class="container" method="post" enctype="multipart/form-data">
        <div class="row g-3">
            <div class="col">
                <label for="name" class="form-label">Имя</label>
                <input name="name" id="name" type="text" class="form-control" placeholder="Имя" aria-label="Имя">
            </div>
        </div>
        <div class="row g-3">
            <div class="col">
                <label for="phone" class="form-label">Телефон</label>
                <input name="phone" id="phone" type="tel" class="form-control" placeholder="Телефон">
            </div>
            <div class="col">
                <label for="birthday" class="form-label">Дата рождения</label>
                <input name="birthday" id="birthday" type="date" class="form-control" placeholder="Дата рождения">
            </div>
        </div>
        <div class="row">
            <label for="image" class="form-label">Фото профиля</label>
            <input name="image" id="image" type="file" accept="image" class="form-control" placeholder="Фото профиля">
        </div>
        <div class="col">
            <label for="gender" class="form-label">Пол</label>
            <select class="form-control" name="gender" id="gender">
                <#list  genders as gender>
                    <option value="${gender.id}">${gender.type}</option>
                </#list>
            </select>
        </div>
        <div class="col">
            <label for="position" class="form-label">Должность</label>
            <select class="form-control" name="position" id="position">
                <#list  positions as position>
                    <option value="${position.id}">${position.type}</option>
                </#list>
            </select>
        </div>
        <div class="row">
            <button type="submit" class="mx-auto col-8 btn btn-secondary mt-5 ">Сохранить</button>
        </div>
    </form>


</@component.skeleton>