<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    <form class="container" action="/admin/hall/add" method="post">
        <select class="form-select" size="5" aria-label="">
            <#list halls as hall>
                <option>${hall.name}</option>
            </#list>
        </select>
        <label for="name">Новый зал</label>
        <input type="text" name="name">
        <button>Добавить</button>
    </form>
    <form class="container" action="/admin/continuance/add" method="post">
        <select class="form-select" size="5" aria-label="">
            <#list continuances as continuance>
                <option> ${continuance.type} (${continuance.days})</option>
            </#list>
        </select>
        <label for="name">Новая длительность абонемента</label>
        <input type="text" name="type">
        <input type="number" min="0" name="days">
        <button>Добавить</button>
    </form>
    <form class="container" action="/admin/position/add" method="post">
        <select class="form-select" size="5" aria-label="">
            <#list positions as position>
                <option>${position.type}</option>
            </#list>
        </select>
        <label for="name">Новая должность</label>
        <input type="text" name="type">
        <button>Добавить</button>
    </form>

</@component.skeleton>