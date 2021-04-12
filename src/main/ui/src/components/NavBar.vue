<template>
    <nav class="navbar navbar-expand-md navbar-light bg-light">
        <div class="container">

            <div class="d-flex flex-row align-items-center justify-content-between d-md-none d-block w-100">
                <div class="nav-brand">
                    <h2>
                        Jacob Gonzalez
                    </h2>
                </div>
                <div>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar-collapse" aria-controls="navbar-collapse" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </div>
            </div>

            <div class="collapse navbar-collapse" id="navbar-collapse">
                <div class="d-flex flex-md-row flex-column text-center justify-content-between w-100" >

                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <router-link to="/" class="nav-link text-muted">
                                <i class="fas fa-home"></i> Home
                            </router-link>
                            
                        </li>
                        <li class="nav-item">
                            <a th:href="@{/about}" class="nav-link text-muted"><i class="far fa-address-card"></i> About</a>
                        </li>
                        <li class="nav-item">
                            <a th:href="@{/contact}" class="nav-link text-muted"><i class="far fa-envelope"></i> Contact</a>
                        </li>
                    </ul>


                    <ul class="navbar-nav">
                        <li class="nav-item" sec:authorize="isAnonymous()">
                            <a th:href="@{login}"  class="nav-link text-muted"><i class="fas fa-sign-in-alt"></i> Sign Up/Sign In</a>
                        </li>
                        <li class="nav-item" sec:authorize="isAuthenticated()">
                            <a th:href="@{/logout}"  class="nav-link text-muted"><i class="fas fa-sign-out-alt"></i> Logout</a>
                        </li>
                        <li class="nav-item" sec:authorize="isAuthenticated()">
                            <a th:href="@{/post/create}"  class="nav-link text-muted"><i class="far fa-plus-square"></i> New Post</a>
                        </li>
                    </ul>

                </div>
            </div>
            

        </div>
    </nav>
</template>
