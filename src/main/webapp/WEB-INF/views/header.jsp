
<!-- Include jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<div class="navbar-wrapper">
    <div class="container-fluid">
        <nav class="navbar navbar-fixed-top">
            <div class="container" style="margin-top: 25px;">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"> <img style="height: 40px;" src="http://cosmicit.youronlinespot.de/wp-content/uploads/2017/06/logo-sm.png" alt="Logo"></img></a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#" class="">Home</a></li>
                        <li class=" dropdown">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Users <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class=" dropdown">
                                    <a href="/userslist" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">View Users</a>
                                </li>
                                <li><a href="/newuser">Add New</a></li>
                            </ul>
                        </li>
                        <li class=" dropdown"><a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Registrations <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/registration/search/person">Search</a></li>
                                <li><a href="/registration/">Add New</a></li>
                            </ul>
                        </li>
                        <li class=" dropdown"><a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Persons <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/person/search">Search</a></li>
                                <li><a href="/person/list">List All</a></li>
                                <li><a href="/person">Add New</a></li>
                                <li><a href="/person/edit">Edit</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <li class=" dropdown"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Signed in as  <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Change Password</a></li>
                                <li><a href="#">My Profile</a></li>
                            </ul>
                        </li>
                        <li class=""><a href="#">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>