import React, { useEffect } from 'react';
import './index.css'; // Import CSS file for styling

function StateWebsite() {
    useEffect(() => {
        // Fetch and include nav-bar.html using JavaScript
        fetch('../NAV-BAR (header)/nav-bar.html')
            .then(response => response.text())
            .then(html => {
                document.getElementById('navbar-container').innerHTML = html;
            })
            .catch(error => {
                console.error('Error fetching nav-bar.html:', error);
            });
    }, []);

    // Function to toggle dropdown
    function toggleDropdown(dropdownId) {
        var dropdown = document.getElementById(dropdownId);
        if (dropdown.classList.contains('show')) {
            dropdown.classList.remove('show');
        } else {
            // Hide all other dropdowns before showing this one
            var dropdowns = document.getElementsByClassName('dropdown-content');
            for (var i = 0; i < dropdowns.length; i++) {
                dropdowns[i].classList.remove('show');
            }
            dropdown.classList.add('show');
        }
    }

    // Close the dropdown if the user clicks outside of it
    window.onclick = function (e) {
        if (!e.target.matches('.dropbtn')) {
            var dropdowns = document.getElementsByClassName('dropdown-content');
            for (var i = 0; i < dropdowns.length; i++) {
                var dropdown = dropdowns[i];
                if (dropdown.classList.contains('show')) {
                    dropdown.classList.remove('show');
                }
            }
        }
    };

    return (
        <div>
            <div id="navbar-container"></div>
            <div className="opening-image">
                <header>
                    <div className="opening-text">
                        <h1>Welcome to the City of Williamston!</h1>
                    </div>
                </header>
            </div>

            <main>
                <div className="announcement">
                    <h2>This Week's Announcements:</h2>
                    <p>Event info goes here</p>
                </div>

                <div className="current-events">
                    <h2>Current Events</h2>
                    <nav>
                        <ol>
                            <li><a href="#">Event 1</a></li>
                            <li><a href="#">Event 2</a></li>
                            <li><a href="#">Event 3</a></li>
                            <li><a href="#">Event 4</a></li>
                        </ol>
                    </nav>
                </div>

                <div className="article">
                    <article>
                        <h2>Event 1</h2>
                        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Obcaecati repellendus animi, ab voluptas consectetur deserunt eaque non ducimus molestiae beatae quod quia dolorem repudiandae exercitationem? Magni laudantium animi totam distinctio!</p>
                        <a href="#">Click Here to Find out more</a>
                    </article>
                </div>

                <h2>Services</h2>
                <div className="serviceimg">
                    <div className="navbar">
                        <div className="dropdown">
                            <button className="dropbtn" onClick={() => toggleDropdown('services&SafetyDropdown')}>Services & Safety
                                <i className="fa fa-caret-down"></i>
                            </button>
                            <div className="dropdown-content" id="services&SafetyDropdown">
                                <a href="#">Water and sewer</a>
                                <a href="#">Sanitation</a>
                                <a href="#">Police department</a>
                            </div>
                        </div>
                        {/* Add other dropdowns similarly */}
                    </div>
                </div>

                <div className="contact-info">
                    <h2 id="Contact">Contact Information</h2>
                    <p><strong>Contact With Us</strong>
                        <br/>Phone Number: <br/>Email:
                        <br/>Address: <br/>Social Media:
                    </p>
                </div>
            </main>
            <footer>
                <p>&copy; 2024 State Name. All Rights Reserved.</p>
            </footer>
        </div>
    );
}

export default StateWebsite;
