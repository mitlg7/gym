<#macro navbar>
    <#include "know.ftlh">

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Главная</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse ml-7" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <#if known >
                        <li class="nav-item">
                            <a class="nav-link text-white" href="/user">ЛК ${name}</a>
                        </li>
                        <#else >
                        <li class="nav-item">
                        <a class="nav-link text-white" href="/login">Логин</a>
                    </li>
                    </#if>

                </ul>
                <#if known>
                    <ul class="navbar-nav mr-auto">

                        <li class="nav-item">
                            <a class="nav-link text-white" href="/manage">manage</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link text-white" href="/client/create">Регистрация клиента</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link text-white" href="/trainer/create">Регистрация тренера</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link text-white" href="/subscription/create">Новый абонемент</a>
                        </li>
                    </ul>>
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link text-white" href="/admin/clients">Управление клиентами</a>
                        </li>
                    </ul>
                </#if>

            </div>
        </div>
    </nav>

</#macro>