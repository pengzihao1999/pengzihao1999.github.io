function g = sigmoid(z)
%SIGMOID Compute sigmoid function
%   g = SIGMOID(z) computes the sigmoid of z.

% You need to return the following variables correctly 
g = zeros(size(z));

% ====================== YOUR CODE HERE ======================
% Instructions: Compute the sigmoid of each value of z (z can be a matrix,
%               vector or scalar).
% z传入的可能是一个矩阵 返回的g(通过sigmoid函数返回的要是1/e^-z+1)也是一个矩阵
g = exp(z)./(exp(z)+1);



% =============================================================

end
