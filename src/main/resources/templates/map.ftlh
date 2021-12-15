<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>

    <div class="container mt-5">
        <div class="row d-flex justify-content-center">
            <div class="col-md-10">
                <div class="card">
                    <div style='' class="container text-center mt-4">
                        <p class="fs-4">Приходите к нам по нашему адресу и<br> запишитесь на одно бесплатное занятие.
                        </p>
                        <iframe class="border border-primary m-5"
                                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2482.2144649399693!2d45.982052215961!3d51.52762611704478!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4114c7aa7443a281%3A0xfa9c3268188dcac7!2z0JHQtdCz0L7QstCw0Y8g0YPQuy4sIDMvOSwg0KHQsNGA0LDRgtC-0LIsINCh0LDRgNCw0YLQvtCy0YHQutCw0Y8g0L7QsdC7LiwgNDEwMDU0!5e0!3m2!1sru!2sru!4v1639522818190!5m2!1sru!2sru"
                                width="800" height="600" style="border:0;" allowfullscreen="" loading="lazy"></iframe>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Maven+Pro&display=swap');

        body {
            font-family: 'Maven Pro', sans-serif;
        }

        hr {
            color: #0000004f;
            margin-top: 5px;
            margin-bottom: 5px
        }

        .add td {
            color: #c5c4c4;
            text-transform: uppercase;
            font-size: 12px
        }

        .content {
            font-size: 14px
        }
    </style>
</@component.skeleton>


