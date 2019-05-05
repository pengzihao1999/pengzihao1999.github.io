function [J, grad] = costFunctionReg(theta, X, y, lambda)
%COSTFUNCTIONREG Compute cost and gradient for logistic regression with regularization
%   J = COSTFUNCTIONREG(theta, X, y, lambda) computes the cost of using
%   theta as the parameter for regularized logistic regression and the
%   gradient of the cost w.r.t. to the parameters. 

% Initialize some useful values
m = length(y); % number of training examples

% You need to return the following variables correctly 
J = 0;
grad = zeros(size(theta));

% ====================== YOUR CODE HERE ======================
% Instructions: Compute the cost of a particular choice of theta.
%               You should set J to the cost.
%               Compute the partial derivatives and set grad to the partial
%               derivatives of the cost w.r.t. each parameter in theta


%
K = zeros(size(theta)-1);
% J是输出经过costFunction后的代价函数的值%
% grad矩阵是经过costFunction后θ更新的矩阵值%

% Step1 首先要把传入的X矩阵经过sigmoid函数进行转换
A = sigmoid(X*theta);
% Step2 求J(θ) 记住从θ1开始进行 所以要计算出从θ2开始之后的下标进行 
% theta(2:1:size(theta)(1),:).^2 ->使矩阵取第二行到最后一行
J = sum(-y.*log(A)-(1-y).*log(1-A))/m + lambda/(2*m)*sum(theta(2:1:size(theta)(1),:).^2);
%  grad矩阵是进行一次梯度下降后的结果矩阵 同样 θ1 和 θj（2<=j<=size(theta))
%对θ1进行单独求解
grad(1) = (X'(1,:)*(A-y))/m;
%对θ2—θj j=size(theta)(1)

K = (X'(2:1:size(X')(1),:)*(A-y))/m;
V = K + lambda/m*theta(2:1:size(theta)(1),:);
grad = [grad(1);K];








% =============================================================

end
