import React from 'react';
import './styles.css';

class CommunityPage extends React.Component {
    constructor(props) {
        super(props);
        this.openTab = this.openTab.bind(this); // Bind openTab method to the component instance
    }

    render() {
        return (
            <div>
                <input
                    type="text"
                    placeholder="Search..."
                    className="search-bar"
                />

                <nav>
                    <a href="Index.html">Home </a>
                    <a href="AboutUs.html">About </a>
                    <a href="#">Government </a>
                    <a href="#">Services </a>
                    <a href="Contact.html">Contact </a>
                    <a href="#">Event </a>

                </nav>

                <h1 className="about">Community Page</h1>
                
                <div className="tab">
                    <a href="#" className="tablinks" onClick={(e) => this.openTab(e, 'things-to-do')}>Things to do</a>
                    <a href="#" className="tablinks" onClick={(e) => this.openTab(e, 'news')}>News</a>
                    <a href="#" className="tablinks" onClick={(e) => this.openTab(e, 'meetings')}>Meetings</a>
                </div>
                
                <div id="things-to-do" className="tabcontent">
                    <h2>Things to do</h2>
                    <p>Volunteer for community events, join a community group or club, attend community meetings.</p>
                </div>
                
                <div id="news" className="tabcontent">
                    <h2>News</h2>
                    <p>Stay updated with the latest community news and announcements.</p>
                </div>
                
                <div id="meetings" className="tabcontent">
                    <h2>Meetings</h2>
                    <p>Information about upcoming community meetings and events.</p>
                </div>
            </div>
        );
    }

    openTab(evt, tabName) {
        let i, tabcontent, tablinks;
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }
        document.getElementById(tabName).style.display = "block";
        evt.currentTarget.className += " active";
    }
}

export default CommunityPage;
