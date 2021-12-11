<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    <form class="container" method="post">
        <div class="row g-3">
            <div class="col">
                <label for="name" class="form-label">Название</label>
                <input name="name" id="name" type="text" class="form-control" placeholder="Название">
            </div>
            <div class="col">
                <label for="price" class="form-label">Стоимость</label>
                <input name="price" id="price" type="number" min="0" class="form-control" placeholder="Стоимость">
            </div>
        </div>

        <div class="col">
            <label for="trainer" class="form-label">Тренер</label>
            <select class="form-control" name="trainer" id="trainer">
                <#list  trainers as trainer>
                    <option value="${trainer.id}">${trainer.name} / ${trainer.getLettersGender()}</option>
                </#list>
            </select>
        </div>
        <div class="row g-3">
            <div class="col">
                <label for="hall" class="form-label">Зал</label>
                <select class="form-control" name="hall" id="hall">
                    <#list  halls as hall>
                        <option value="${hall.id}">${hall.name}</option>
                    </#list>
                </select>
            </div>
            <div class="col">
                <label for="continuance" class="form-label">Продолжительность</label>
                <select class="form-control" name="continuance" id="continuance">
                    <#list  continuances as continuance>
                        <option value="${continuance.id}">${continuance.type}(${continuance.days} дней)</option>
                    </#list>
                </select>
            </div>
        </div>
        <button>Добавить</button>
    </form>

</@component.skeleton>