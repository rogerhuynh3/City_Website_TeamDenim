import React, { useEffect } from 'react';
import './contact.css'; // Import CSS file for styling

function ContactUs() {
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

    return (
        <div>
            <div id="navbar-container"></div>
            <div className="send-message-info">
                <h1 className="message-title">SEND US A MESSAGE</h1>
                <form id="send_message">
                    <label className="enter">ENTER YOUR NAME</label>
                    <label htmlFor="first_name" id="first_name-label">
                        <input id="first_name" type="text" placeholder="FIRST NAME" required/>
                    </label>
                    <label htmlFor="last_name" id="last_name-label">
                        <input id="last_name" type="text" placeholder="LAST NAME" required/>
                    </label>
                    <br/>
                    <label className="enter">ENTER YOUR EMAIL</label>
                    <label htmlFor="email" id="email-label">
                        <input id="email" type="email" placeholder="johnsmith08@gmail.com" required/>
                    </label>
                    <br/>
                    <label className="enter">ENTER YOUR MESSAGE</label>
                    <label htmlFor="message">
                        <textarea id="message" name="message" rows="3" cols="30" placeholder="When is the banquet?"></textarea>
                        <br/>
                        <input id="submit" type="submit" value="SUBMIT"/>
                    </label>
                </form>
            </div>
            <br/><br/>
            <div className="contact_info">
                <h1 className="contactus-title">CONTACT US</h1>
                <h2>Phone: (517) 655-2774 <br/> 
                    FAX: (517) 655-2797 <br/>
                    Address: 161 East Grand River Avenue Williamston, MI 48895 <br/>
                    Hours: Monday-Friday: 8:00am - 5:00pm Saturday-Sunday: Closed
                </h2>
            </div>
        </div>
    );
}

export default ContactUs;
