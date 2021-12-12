<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    <div class="container">
        <div class="row ">
            <img class="col-6" src="/img/index.png">

            <div class="col-lg-6 pt-5 pt-lg-0 order-2 order-lg-1 d-flex flex-column justify-content-center">
                <h1>Профессионалы высокого уровня</h1>
                <h2>Приглашаем присоединиться к нашему фитнес-клубу - Нон стоп</h2>
                <div class="d-flex">
                    <div class="my-3 btn btn-lg btn-warning fw-bold">Присоединиться</div>
                </div>
                <div class="row mt-4">
                    <div class="col-lg-4 col-md-6">
                        <div class="icon-box">
                            <div class="icon"><i class="bi bi-laptop"></i></div>
                            <h4 class="title"><a class="text-warning" href="/hall/all">Залы</a></h4>
                            <p class="description">В тренажерном зале на территории 200 кв.м Вы найдете оборудование
                                ведущих производителей, а также тренажеры для работы со свободными весами. Для Вашего комфорта оборудование
                                распределено по залу максимально эргономично.</p>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mt-4 mt-md-0">
                        <div class="icon-box">
                            <div class="icon"><i class="bi bi-card-checklist"></i></div>
                            <h4 class="title"><a class="text-warning" href="/trainer/all">Тренеры</a></h4>
                            <p class="description">Все тренеры тренажерного зала обладают званиями мастера спорта или
                                кандидата в мастера спорта. Именно эти люди помогут Вам добиться впечатляющих
                                результатов.</p>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mt-4 mt-lg-0">
                        <div class="icon-box">
                            <div class="icon"><i class="bi bi-clipboard-data"></i></div>
                            <h4 class="title"><a class="text-warning" href="/subscription/all">Абонементы</a></h4>
                            <p class="description">
                                Чем больше длительность абонемента, тем выгоднее цена! Занимайтесь в любое
                                время работы клуба и пользуйтесь всеми услугами с безлимитной картой либо подстройте
                                фитнес.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!-- Footer -->
    <footer class="page-footer font-small mdb-color lighten-3 pt-4">

        <!-- Footer Links -->
        <div class="container text-center text-md-left">
            <div class="row">
                <div class="col-md-4 col-lg-3 mr-auto my-md-4 my-0 mt-4 mb-1">
                    <h5 class="font-weight-bold text-uppercase mb-4">Non stop - фитнес клуб</h5>
                </div>
                <hr class="clearfix w-100 d-md-none">
                <div class="col-md-2 col-lg-2 mx-auto my-md-4 my-0 mt-4 mb-1">
                    <h5 class="font-weight-bold text-uppercase mb-4">О нас</h5>
                </div>
                <hr class="clearfix w-100 d-md-none">

                <div class="col-md-4 col-lg-3 mx-auto my-md-4 my-0 mt-4 mb-1">

                    <h5 class="font-weight-bold text-uppercase mb-4">Адресс</h5>

                    <ul class="list-unstyled">
                        <li>
                            <p>
                                <i class="fas fa-home mr-3"></i> Саратов, Беговая 3\9</p>
                        </li>
                        <li>
                            <p>
                                <i class="fas fa-envelope mr-3"></i> nonstop@example.com</p>
                        </li>
                        <li>
                            <p>
                                <i class="fas fa-phone mr-3"></i> +7 800 300 20 20</p>
                        </li>
                    </ul>

                </div>

                <hr class="clearfix w-100 d-md-none">

                <div class="col-md-2 col-lg-2 text-center mx-auto my-4">

                    <h5 class="font-weight-bold text-uppercase mb-4">Соц сети</h5>

                    <a type="button" class="btn-floating btn-fb">
                        <i class="fab fa-facebook-f"></i>
                    </a>
                    <a type="button" class="btn-floating btn-tw">
                        <i class="fab fa-twitter"></i>
                    </a>
                    <a type="button" class="btn-floating btn-gplus">
                        <i class="fab fa-google-plus-g"></i>
                    </a>
                    <a type="button" class="btn-floating btn-dribbble">
                        <i class="fab fa-dribbble"></i>
                    </a>

                </div>

            </div>

        </div>
        <div class="footer-copyright text-center py-3">© 2021
        </div>

    </footer>

</@component.skeleton>