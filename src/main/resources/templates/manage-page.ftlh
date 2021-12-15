<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    <form class="container col-10 mt-3" action="/admin/hall/add" method="post">
        <select class="form-select" size="5" aria-label="">
            <#list halls as hall>
                <option>${hall.name} </option>
            </#list>
        </select>
        <div class="input-group mb-3 mt-1">
            <label class="input-group-text" for="name">Новый зал:</label>
            <input type="text" id="name" name="name" class="form-control" placeholder="Название зала" aria-describedby="button-addon2">
            <button class="btn btn-outline-secondary" id="button-addon2">Добавить</button>
        </div>
    </form>
    <form class="container col-10" action="/admin/continuance/add" method="post">
        <select class="form-select" size="5" aria-label="">
            <#list continuances as continuance>
                <option> ${continuance.type} (${continuance.days} дней))</option>
            </#list>
        </select>
        <div class="input-group mb-3 mt-1">
            <label class="input-group-text" for="type">Новая длительность абонемента:</label>
            <input type="text" id="type" name="type" class="form-control" placeholder="Название" aria-describedby="button-addon2">
            <input type="number" id="name" name="days" class="form-control" placeholder="Количество дней" aria-describedby="button-addon2">
            <button class="btn btn-outline-secondary" id="button-addon2">Добавить</button>
        </div>
    </form>
    <form class="container col-10" action="/admin/position/add" method="post">
        <select class="form-select" size="5" aria-label="">
            <#list positions as position>
                <option>${position.type}</option>
            </#list>
        </select>
        <div class="input-group mb-3 mt-1">
            <label class="input-group-text" for="type">Новая должность: </label>
            <input type="text" id="type" name="type" class="form-control" placeholder="Должность" aria-describedby="button-addon2">
           <button class="btn btn-outline-secondary" id="button-addon2">Добавить</button>
        </div>
    </form>

</@component.skeleton>