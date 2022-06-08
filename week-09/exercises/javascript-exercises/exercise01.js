// MANAGER FEATURE REQUESTS
// You have three managers: A, B, and C.
// Occasionally, they ask you to add features to your company software.
// Use if/else statements to enforce the following rules:
// - If all three ask for the feature, print "Feature in progress."
// - If any two of the three ask, print "Adding feature to schedule."
// - If only one of the three ask, print "Going to hold off for a bit."
// - If none of the managers ask, print "Nothing to do..."

const managerAAsked = true;
const managerBAsked = true;
const managerCAsked = true;

if (managerAAsked === true && managerBAsked && managerCAsked === true) {
    console.log("Feature in progress");
} else if ((managerAAsked === true && managerBAsked === true) || (managerAAsked === true && managerCAsked === true) || (managerBAsked === true && managerCAsked === true)) {
    console.log("Adding feature to schedule.");
} else if (managerAAsked === true || managerBAsked === true || managerCAsked === true) {
    console.log("Going to hold off for a bit.");
} else if (managerAAsked === false && managerBAsked === false && managerCAsked === false) {
    console.log("nothing to do.");
};
// 1. Add decisions statements to cover all scenarios.
// 2. Change manager variables to test all scenarios.